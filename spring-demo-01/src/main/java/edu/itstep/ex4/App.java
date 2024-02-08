package edu.itstep.ex4;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("applicationContext4.xml");

        Player player = container.getBean("player", Player.class);
        player.shoot();
    }
}
