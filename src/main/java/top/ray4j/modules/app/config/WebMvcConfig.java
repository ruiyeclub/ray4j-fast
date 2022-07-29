package top.ray4j.modules.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.ray4j.modules.app.interceptor.AuthorizationInterceptor;

/**
 * MVC配置
 *
 * @author: Cr.
 * @date: 2022/7/29
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private AuthorizationInterceptor authorizationInterceptor;
}
