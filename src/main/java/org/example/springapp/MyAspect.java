package org.example.springapp;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {

    @Around("execution(* org.example.springapp.services.*.*(..))")
    public Object advise(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Beginning transaction");
        try {
            Object returnValue = joinPoint.proceed(); // Call the target method
            System.out.println("Committing");
            return returnValue;
        } catch (Exception e) {
            System.out.println("Rolling back");
            throw e;
        }
    }
}
