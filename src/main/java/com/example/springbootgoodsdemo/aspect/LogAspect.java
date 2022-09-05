package com.example.springbootgoodsdemo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component
@Aspect
public class LogAspect {

    @Around("execution(* com.example.springbootgoodsdemo.service..*.*(..))")
    public Object printLogAspect(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String methodName = proceedingJoinPoint.getSignature().getName();
        log.debug("----当前执行的类: {}", proceedingJoinPoint.getSignature().getClass());
        log.debug("----当前方法: {},参数: {}", methodName, Arrays.toString(proceedingJoinPoint.getArgs()));
        Object proceed = proceedingJoinPoint.proceed();
        log.debug("----当前方法执行完成: {}", methodName);
        return proceed;
    }
}
