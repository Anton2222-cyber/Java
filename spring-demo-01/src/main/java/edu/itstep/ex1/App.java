package edu.itstep.ex1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
//        Player player = new Player();
//        player.shoot();

        ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("applicationContext1.xml");
        Player player = container.getBean("player", Player.class);
        player.shoot();
    }
}
