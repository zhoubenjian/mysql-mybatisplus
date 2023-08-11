package com.benjamin.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    /**
     * 作用在com.benjamin.service下的方法
     */
    @Pointcut("execution(* com.benjamin.service..*(..))")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void log(JoinPoint joinPoint) {
        System.out.println("***BEFORE***");
    }
}
