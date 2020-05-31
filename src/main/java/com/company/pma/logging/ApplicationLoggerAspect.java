package com.company.pma.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Aspect
@Component
public class ApplicationLoggerAspect {

    private final Logger log = LoggerFactory.getLogger(this.getClass());


    // where//location to apply logging
    @Pointcut("within(com.company.pma.controller..*)")
    public void definePackagePointCuts() {

    }

    // what , advice
    @Around("definePackagePointCuts()")
    public Object logAround(ProceedingJoinPoint joinPoint) {
        log.debug("\n \n \n");
        log.debug("************** Before method execution :: ******************** \n " +
                        "{}.{} () with argument[s] = {}",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),
                Arrays.toString(joinPoint.getArgs()));
        log.debug("___________________________________");
        Object proceed = null;
        try {
            proceed = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        log.debug("************** After method execution :: ******************** \n " +
                        "{}.{} () with argument[s] = {}",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),
                Arrays.toString(joinPoint.getArgs()));
        log.debug("___________________________________");

        return proceed;
    }
}
