package org.example.ex3;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class Logging {
//    @Before("execution(* get*(..))")
//    public void beforeGet(JoinPoint joinPoint){
//        System.out.println("--------------");
//        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//        System.out.println(methodSignature.getName());
//        System.out.println(methodSignature.getReturnType());
//        System.out.println("LOG");
//    }

    @Pointcut("execution(* create(int))")
    public void createWithParam(){}
    @Pointcut("execution(* create())")
    public void createWithoutParam(){}

    @Before("createWithParam() || createWithoutParam()")
    public void beforeGet(JoinPoint joinPoint){
        System.out.println("--------------");
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();
        if (args.length == 0) {
            System.out.println("LOG: " + methodSignature.getName() + " call without params");
        }else{
            System.out.println("LOG: " + methodSignature.getName() + " call with: " + args[0]);
        }
    }
}
