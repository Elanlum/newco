package com.andreitop.newco.aspect;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LogManager.getLogger(LoggingAspect.class);


    @Before("com.andreitop.newco.aspect.PointcutContainer.repositoryFind()")
    public void beforeRepoFind(JoinPoint joinPoint) {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        logger.info(" ---> Method " + className + "." + methodName + " is about to be called");
    }

    @AfterReturning(pointcut = "com.andreitop.newco.aspect.PointcutContainer.repositorySave()", returning = "returnValue")
    public void afterReturningRepo(JoinPoint joinPoint, Object returnValue) {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        logger.info("If method " + className + "." + methodName + " is called, class runs correctly and returns" + returnValue);
    }

    @AfterThrowing(pointcut = "com.andreitop.newco.aspect.PointcutContainer.repositoryDelete()", throwing = "ex")
    public void afterThrowingRepo(JoinPoint joinPoint, Throwable ex) {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        logger.info("---------> If method " + className + "." + methodName + " is called, class throws an exception");
        System.out.println("---------> If method " + className + "." + methodName + " is called, class throws an exception" + ex);
    }
}
