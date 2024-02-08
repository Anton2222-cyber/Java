package org.example.ex2.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
@Order(1)
public class Security {
    @Pointcut("execution( * get*(..))")
    private void allGet(){}

    @Before("allGet()")
    public void logTime() {
        System.out.println("CHECK SECURITY");
    }

}
