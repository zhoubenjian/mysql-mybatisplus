package com.benjamin.annotation;

import java.lang.annotation.*;

/**
 * 自定义非空注解（@NotNull）
 */
@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotNull {

    String value() default "";

    String message() default "";

    String name() default "";
}
