package com.diflows.backend.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DiFlowsLogAspect {
    @Around("@annotation(com.diflows.backend.aspect.DiFlowsLog)")
    public Object diFlowsLogAspectAround(ProceedingJoinPoint point) throws Throwable {
        System.out.println("before");
        Object result = point.proceed();
        System.out.println("after");
        return result;
    }
}
