package com.iheima.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class RecordTimeAspect {

    @Pointcut("execution(* com.iheima.service.impl.*.*(..))")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object recordTime(ProceedingJoinPoint pjp) throws Throwable {
        long begin = System.currentTimeMillis();

        Object result = pjp.proceed();

        long end = System.currentTimeMillis();
        log.info("Time taken: {} ms", end - begin);

        return result;
    }




}
