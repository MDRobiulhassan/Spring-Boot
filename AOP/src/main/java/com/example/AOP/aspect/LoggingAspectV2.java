package com.example.AOP.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspectV2 {

    @Before("allServiceMethodPointCut()")
    public void beforeServiceMethodCalls(JoinPoint joinPoint) {
        log.info("Before Advice Method Calls,{}",joinPoint.getSignature());
    }

    @After("allServiceMethodPointCut()")
    public void afterServiceMethodCalls(JoinPoint joinPoint) {
        log.info("After Advice Method Calls,{}",joinPoint.getSignature());
    }

    @AfterReturning(value = "allServiceMethodPointCut()",returning = "returnedObj")
    public void afterReturningServiceMethodCalls(JoinPoint joinPoint, Object returnedObj) {
        log.info("After Returning Advice Method Calls,{}",joinPoint.getSignature());
        log.info("After Returning Returned Value,{}",returnedObj);
    }

    @AfterThrowing("allServiceMethodPointCut()")
    public void afterThrowingServiceMethodCalls(JoinPoint joinPoint) {
        log.info("After Throwing Advice Method Calls,{}",joinPoint.getSignature());
    }

    @Around("allServiceMethodPointCut()")
    public Object logExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object returnedValue = proceedingJoinPoint.proceed();

        long endTime = System.currentTimeMillis();
        Long diff = endTime - startTime;
        log.info("Execution time for {} is {} ms",proceedingJoinPoint.getSignature(),diff);
        return returnedValue;
    }

    @Pointcut("execution(* com.example.AOP.serviceimpl.*.*(..))")
    public void allServiceMethodPointCut(){
    }
}
