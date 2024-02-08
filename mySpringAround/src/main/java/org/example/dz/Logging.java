package org.example.dz;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
@Aspect
public class Logging implements AutoCloseable {
    private PrintWriter logWriter;

    public Logging() {
        try {

            logWriter = new PrintWriter(new FileWriter("log.txt", true));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Around("execution(* org.example.dz.User.set*(*))")
    public Object aroundSetters(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        String methodName = method.getName();
        String timestampBegin = getTimestamp();

        logToFile("begin " + methodName + "() " + timestampBegin);
        System.out.println("begin " + methodName + "() " + timestampBegin);
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            logToFile("data: " + arg);
            System.out.println("data: " + arg);
        }

        Object result = joinPoint.proceed();

        String timestampEnd = getTimestamp();
        logToFile("end " + methodName + "() " + timestampEnd);
        logToFile("\n");
        System.out.println("end " + methodName + "() " + timestampEnd+"\n\n");

        return result;
    }

    private String getTimestamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss:SSS");
        return sdf.format(new Date());
    }

    private void logToFile(String message) {
        try {

            logWriter.println(message);
            logWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        if (logWriter != null) {
            logWriter.close();
        }
    }
}
