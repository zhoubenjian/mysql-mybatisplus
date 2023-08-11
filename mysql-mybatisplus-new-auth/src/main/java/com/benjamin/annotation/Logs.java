package com.benjamin.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Logs {

    /**
     * 模块
     */
    String module() default "";
}
