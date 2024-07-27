package top.ray4j.manage.interceptor;

import io.jsonwebtoken.Claims;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import top.ray4j.common.exception.RRException;
import top.ray4j.manage.annotation.Login;
import top.ray4j.manage.utils.JwtUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 权限（token）验证
 *
 * @author: Cr.
 * @date: 2022/7/29
 */
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private JwtUtils jwtUtils;

    public static final String USER_KEY = "userId";
    public static final String USERNAME_KEY = "username";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Login annotation;
        if (handler instanceof HandlerMethod) {
            annotation = ((HandlerMethod) handler).getMethodAnnotation(Login.class);
        } else {
            return true;
        }

        if (annotation == null) {
            return true;
        }

        // 获取用户凭证
        String token = request.getHeader(jwtUtils.getHeader());
        if (StringUtils.isBlank(token)) {
            throw new RRException(jwtUtils.getHeader() + "不能为空", HttpStatus.UNAUTHORIZED.value());
        }

        // 凭证为空
        if (StringUtils.isBlank(token)) {
            throw new RRException(jwtUtils.getHeader() + "不能为空", HttpStatus.UNAUTHORIZED.value());
        }
        // fixme: 处理swagger给token加前缀问题
        Claims claims = jwtUtils.getClaimByToken(token.replace("Bearer", ""));
        if (claims == null || jwtUtils.isTokenExpired(claims.getExpiration())) {
            throw new RRException(jwtUtils.getHeader() + "失效，请重新登录", HttpStatus.UNAUTHORIZED.value());
        }

        // 设置userId到request里，后续根据userId，获取用户信息
        request.setAttribute(USER_KEY, claims.get(USER_KEY));
        request.setAttribute(USERNAME_KEY, claims.get(USERNAME_KEY));

        return true;
    }
}
