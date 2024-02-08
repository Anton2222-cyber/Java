package edu.itstep.ex5;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("start");
        ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("applicationContext5.xml");
        System.out.println("SpringContainer created");
        Gun gun1 = container.getBean("gun", Gun.class);
        Gun gun2 = (Gun) container.getBean("gun");
        gun1.shoot();
        gun2.shoot();
//        System.out.println(gun1);
//        System.out.println(gun2);
//        System.out.println(gun1 == gun1);
//        System.out.println(gun1.equals(gun2));
        System.out.println("finish");
        container.close();
        gun1.destroyMethod();
        gun2.destroyMethod();
    }
}
