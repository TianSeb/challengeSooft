package com.sooft.challenge.common.logging;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.UUID;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @Value("${app.logging.aspect.enabled:true}")
    private boolean loggingEnabled;

    @Before("execution(* com.sooft.challenge..adapter.in..*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String requestId = UUID.randomUUID().toString();
        MDC.put("requestId", requestId);

        Object[] args = joinPoint.getArgs();
        log.info("[{}] Entering: {} with args: {}",
                requestId,
                joinPoint.getSignature().toShortString(),
                Arrays.toString(args));
    }

    @AfterReturning(pointcut = "execution(* com.sooft.challenge..adapter.in..*(..))",
            returning = "result")
    public void logMethodExit(JoinPoint joinPoint, Object result) {
        String requestId = MDC.get("requestId");
        log.info("[{}] Exiting: {} with result: {}",
                requestId,
                joinPoint.getSignature().toShortString(),
                result != null ? result.toString() : "void");
        MDC.clear();
    }

    @AfterThrowing(pointcut = "execution(* com.sooft.challenge..adapter.in..*(..))",
            throwing = "ex")
    public void logException(JoinPoint joinPoint, Throwable ex) {
        String requestId = MDC.get("requestId");
        log.error("[{}] Exception in {}: {}", requestId,
                joinPoint.getSignature().toShortString(),
                ex.getMessage(), ex);
        MDC.clear();
    }
}

