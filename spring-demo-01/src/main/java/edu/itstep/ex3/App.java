package edu.itstep.ex3;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("applicationContext3.xml");

        Player player = container.getBean("player", Player.class);
        player.shoot();
    }
}
