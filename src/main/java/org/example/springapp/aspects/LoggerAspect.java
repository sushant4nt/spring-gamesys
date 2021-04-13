package org.example.springapp.aspects;

import org.apache.logging.log4j.LogManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

    @Before("execution(* org.example.springapp.beans.*.*(..))")
    public void log(JoinPoint joinPoint) {
        String fullyQualifiedName = joinPoint.getSignature().getDeclaringTypeName();
        String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        LogManager.getLogger(fullyQualifiedName).debug(String.format("%s::%s", className, methodName));
    }
}
