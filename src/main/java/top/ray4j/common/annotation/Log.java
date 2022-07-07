package top.ray4j.common.annotation;

import java.lang.annotation.*;

/**
 * 系统日志注解
 *
 * @author: Cr.
 * @date: 2022/7/7
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

    String value() default "";
}
