package com.example.AOP.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Before("execution(* com.example.AOP.serviceimpl.ShipmentServiceImpl.*(..))")
    public void beforeShippingServiceMethods(JoinPoint joinPoint){
        log.info("Before Method Call kind: {}",joinPoint.getKind());
        log.info("Before Method Call signature : {}",joinPoint.getSignature());
    }

    @After("myLoggingAndAOPAppMethodPointcut()")
    public void myLoggingAndAOPAppMethodPointcut(JoinPoint joinPoint){
        log.info("After MyLogging method call: {}",joinPoint.getSignature());
    }

    @Before("within(com.example.AOP..*)")
    public void beforeServiceImplCalls(JoinPoint joinPoint){
        log.info("ServiceImpl Calls");
    }

    @Before("myLoggingAndAOPAppMethodPointcut()")
    public  void beforeTransactional(JoinPoint joinPoint){
        log.info("Before MyLogging method call: {}",joinPoint.getSignature());
    }

    @Pointcut("@annotation(com.example.AOP.aspect.MyLogging) && within(com.example.AOP..*)")

    public void myLoggingAndAOPAppMethodPointcut(){}
}
