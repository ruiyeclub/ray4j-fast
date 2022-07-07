package top.ray4j.common.aspect;

import com.google.gson.Gson;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.ray4j.common.annotation.Log;
import top.ray4j.common.utils.HttpContextUtils;
import top.ray4j.common.utils.IPUtils;
import top.ray4j.modules.sys.entity.SysLog;
import top.ray4j.modules.sys.entity.SysUser;
import top.ray4j.modules.sys.service.SysLogService;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 系统日志，切面处理类
 *
 * @author: Cr.
 * @date: 2022/7/7
 */
@Aspect
@Component
public class LogAspect {

    @Autowired
    private SysLogService sysLogService;

    @Pointcut("@annotation(top.ray4j.common.annotation.Log)")
    public void logPointCut() {
    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        // 执行方法
        Object result = point.proceed();
        // 执行时长（毫秒）
        long time = System.currentTimeMillis() - beginTime;
        saveSysLog(point, time);

        return result;
    }

    private void saveSysLog(ProceedingJoinPoint joinPoint, long time) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        SysLog sysLog = new SysLog();
        Log log = method.getAnnotation(Log.class);
        if (null != log) {
            // 注解上的描述
            sysLog.setOperation(log.value());
        }

        // 请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysLog.setMethod(className + "." + methodName + "()");

        // 请求的参数
        Object[] args = joinPoint.getArgs();
        try {
            // TODO: 2022/7/7 Gson -> fastjson
            String params = new Gson().toJson(args);
            sysLog.setParams(params);
        } catch (Exception e) {

        }

        // 获取request
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        // 设置IP地址
        sysLog.setIp(IPUtils.getIpAddr(request));

        // 用户名
        String username = ((SysUser) SecurityUtils.getSubject().getPrincipal()).getUsername();
        sysLog.setUsername(username);
        sysLog.setTime(time);
        sysLog.setCreateDate(new Date());
        // 保持系统日志
        sysLogService.save(sysLog);
    }
}
