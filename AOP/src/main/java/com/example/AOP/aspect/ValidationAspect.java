package com.example.AOP.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Aspect
@Component
@Slf4j
public class ValidationAspect {

    @Pointcut("execution(* com.example.AOP.serviceimpl.*.*(..))")
    public void allServiceMethodPointCut(){
    }

    @Around("allServiceMethodPointCut()")
    public Object validateOrderId(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] args = proceedingJoinPoint.getArgs();

        Long orderId = (Long) args[0];

        if(orderId > 0) return proceedingJoinPoint.proceed();
        return "Cannot call negative orderId";
    }
}
