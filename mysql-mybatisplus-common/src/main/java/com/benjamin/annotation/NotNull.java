package com.benjamin.annotation;

import java.lang.annotation.*;

/**
 * 自定义非空注解（@NotNull）
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
public @interface NotNull {

    String value() default "";
}
