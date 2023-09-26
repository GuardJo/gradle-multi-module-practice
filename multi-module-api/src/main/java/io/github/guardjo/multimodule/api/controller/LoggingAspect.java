package io.github.guardjo.multimodule.api.controller;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Aspect
@Slf4j
public class LoggingAspect {
    private final static String MDC_KEY = "traceId";

    @Pointcut(value = "execution(* io.github.guardjo.multimodule.api.controller.*.*(..))")
    public void controllerAspect() {

    }

    @Before("controllerAspect()")
    public void initMdc() {
        MDC.put(MDC_KEY, UUID.randomUUID().toString());
    }

    @After("controllerAspect()")
    public void clearMdc() {
        MDC.clear();
    }
}
