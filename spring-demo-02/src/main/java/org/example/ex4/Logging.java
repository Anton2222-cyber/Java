package org.example.ex4;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class Logging {

//    @Before("execution(* UserStorage.getUsers())")
//    public void beforeGetUsers(JoinPoint joinPoint) {
//        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//        System.out.println("--------------------");
//        System.out.println("BEFORE " + methodSignature.getName());
//        System.out.println("--------------------");
//    }
//
//    @After("execution(* UserStorage.getUsers())")
//    public void afterGetUsers(JoinPoint joinPoint) {
//        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//        System.out.println("--------------------");
//        System.out.println("AFTER " + methodSignature.getName());
//        System.out.println("--------------------");
//    }
//
//    @AfterThrowing(value = "execution(* UserStorage.getUsers())", throwing = "ex")
//    public void afterGetUsers(JoinPoint joinPoint, Exception ex) {
//        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//        System.out.println("--------------------");
//        System.out.println("AFTER THROWING " + methodSignature.getName());
//        System.out.println(ex.getClass().getSimpleName());
//        System.out.println(ex.getMessage());
//        System.out.println("--------------------");
//    }
//
//    @AfterReturning(value = "execution(* UserStorage.getUsers())", returning = "users")
//    public void afterGetUsers(JoinPoint joinPoint, List<User> users) {
//        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//        System.out.println("--------------------");
//        System.out.println("AFTER RETURNING " + methodSignature.getName());
////        users.forEach(user -> System.out.println(user.getFirstName().toUpperCase()));
//        users.forEach(user -> user.setFirstName(user.getFirstName().toUpperCase()));
//        System.out.println("--------------------");
//    }

    @Around("execution(* UserStorage.getUsers())")
    public Object aroundGetUsers(ProceedingJoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("--------------------");
        System.out.println("AROUND start " + methodSignature.getName());


        List<User> users;
        try {
            users = (List<User>) joinPoint.proceed();//виклик getUsers
            users.forEach(user -> user.setFirstName(user.getFirstName().toUpperCase()));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

        System.out.println("AROUND end " + methodSignature.getName());
        System.out.println("--------------------");

        return users;
    }


}
