package com.iheima.aop;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.iheima.mapper.OperateLogMapper;
import com.iheima.pojo.OperateLog;
import com.iheima.utils.CurrentHolder;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class OperationLogAspect {

    private final OperateLogMapper operateLogMapper;

    public OperationLogAspect(OperateLogMapper operateLogMapper) {
        this.operateLogMapper = operateLogMapper;
    }

    @Around("@annotation(com.iheima.anno.Log)")
    public Object logOperation(ProceedingJoinPoint joinPoint) throws Throwable {
        long begin = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long end = System.currentTimeMillis();

        OperateLog operateLog = new OperateLog();
        operateLog.setOperateEmpId(CurrentHolder.getCurrentId());
        operateLog.setOperateTime(LocalDateTime.now());
        operateLog.setClassName(joinPoint.getTarget().getClass().getName());
        operateLog.setMethodName(joinPoint.getSignature().getName());
        operateLog.setMethodParams(Arrays.toString(joinPoint.getArgs()));
        operateLog.setReturnValue(result.toString());
        operateLog.setCostTime(end - begin);
        operateLogMapper.insert(operateLog);

        log.info("Operation log: {}", operateLog);

        
        return result;
    }


}
