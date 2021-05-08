package com.family.spring.core;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class MonitorAspect {
    @Pointcut("execution(* com.family.spring.core..*.*(..))  ")
    public void pointCut() {
    }
    @Around("pointCut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object result = pjp.proceed();
        stopWatch.stop();
        System.out.println("执行" + pjp.getSignature().getName() + "共花费了" + stopWatch.getTotalTimeMillis() + "毫秒");
        return result;
    }
}
