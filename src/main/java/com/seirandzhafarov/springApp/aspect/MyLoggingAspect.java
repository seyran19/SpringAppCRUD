package com.seirandzhafarov.springApp.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyLoggingAspect {

    @Around("execution(* com.seirandzhafarov.springApp.dao.*.*(..))")
    public Object aroundAllRepositoryMethodsAdvice
            (ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();

        String methodName = methodSignature.getMethod().getName();

        System.out.println("Begin of method: " + methodName);

        Object proceed = pjp.proceed();

        System.out.println("End of method: " + methodName);

        return proceed;
    }
}
