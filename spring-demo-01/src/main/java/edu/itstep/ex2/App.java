package edu.itstep.ex2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
//        Gun gun = new Gun();
//        Player player = new Player(gun);
//        player.shoot();

        ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("applicationContext2.xml");

        Player player = container.getBean("player", Player.class);
        player.shoot();
    }
}
