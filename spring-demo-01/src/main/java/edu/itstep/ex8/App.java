package edu.itstep.ex8;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("applicationContext8.xml");

        Player player = container.getBean("player", Player.class);
        player.shoot();
    }
}
