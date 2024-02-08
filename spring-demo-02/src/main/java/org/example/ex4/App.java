package org.example.ex4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Hello world!
 */

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        UserStorage storage = (UserStorage) context.getBean("userStorage");

        System.out.println("start");

        List<User> users = storage.getUsers();
        users.forEach(System.out::println);

        System.out.println("finish");
    }
}
