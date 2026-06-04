package com.example.AOP.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Before("execution(* com.example.AOP.serviceimpl.ShipmentServiceImpl.*(..))")
    public void beforeShippingServiceMethods(JoinPoint joinPoint){
        log.info("Before Method Call : {}",joinPoint.getSignature());
    }
}
