package com.kodilla.patterns2.facade.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Aspect
@Component
public class WatcherFacade {
    private static final Logger LOGGER = LoggerFactory.getLogger(WatcherFacade.class);

    @Before("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    public void LogEvent(){
        LOGGER.info("Class: processOrder --> Start");
    }
}
