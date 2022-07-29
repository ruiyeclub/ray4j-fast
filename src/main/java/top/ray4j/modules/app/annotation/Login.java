package top.ray4j.modules.app.annotation;

import java.lang.annotation.*;

/**
 * app登录校验
 *
 * @author: Cr.
 * @date: 2022/7/29
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Login {
}
