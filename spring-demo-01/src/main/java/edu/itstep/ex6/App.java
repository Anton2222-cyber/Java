package edu.itstep.ex6;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("applicationContext6.xml");
        Gun gun = container.getBean("gun", Gun.class);
        gun.shoot();
    }
}
