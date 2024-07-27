package top.ray4j.common.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import top.ray4j.common.exception.RRException;

/**
 * Redis切面处理类
 *
 * @author: Cr.
 * @date: 2022/7/11
 */
@Slf4j
@Aspect
@Configuration
public class RedisAspect {

    /**
     * 是否开启redis缓存 true开启 false关闭
     */
    @Value("${spring.redis.open: false}")
    private boolean open;

    @Around("execution(* top.ray4j.common.utils.RedisUtils.*(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Object result = null;
        if (open) {
            try {
                result = point.proceed();
            } catch (Exception e) {
                log.error("redis error", e);
                throw new RRException("Redis服务异常");
            }
        }
        return result;
    }
}
