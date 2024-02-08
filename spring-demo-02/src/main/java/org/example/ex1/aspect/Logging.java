package org.example.ex1.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class Logging {

    @Pointcut("execution( * set*(..))")
    private void allSet(){}
    @Pointcut("execution( * get*(..))")
    private void allGet(){}

    @Before("allSet() || allGet()")
    public void logTime() {
        System.out.println("---------: " + LocalDateTime.now());
    }
}
