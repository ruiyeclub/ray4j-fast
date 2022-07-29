package top.ray4j.modules.app.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import top.ray4j.modules.app.annotation.LoginUser;
import top.ray4j.modules.app.interceptor.AuthorizationInterceptor;
import top.ray4j.modules.app.service.TbUserService;
import top.ray4j.modules.sys.entity.SysUser;

/**
 * 有@LoginUser注解的方法参数，注入当前登录用户
 *
 * @author: Cr.
 * @date: 2022/7/29
 */
@Component
public class LoginUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private TbUserService tbUserService;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(SysUser.class) && parameter.hasParameterAnnotation(LoginUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        // 获取用户Id
        Object object = webRequest.getAttribute(AuthorizationInterceptor.USER_KEY, RequestAttributes.SCOPE_REQUEST);
        if (object == null) {
            return null;
        }
        // 获取用户信息
        return tbUserService.getById((Long) object);
    }
}
