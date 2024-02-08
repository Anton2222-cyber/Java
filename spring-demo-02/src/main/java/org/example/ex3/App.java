package org.example.ex3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 */

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserDb userDb = context.getBean(UserDb.class);
        TicketDb ticketDb = context.getBean(TicketDb.class);

        userDb.create();
        ticketDb.create();
        userDb.create(103);
        userDb.create(206);
        userDb.addUser();

//
//        userDb.checkAge();
//        ticketDb.checkPrice();

//        userDb.getUserById();
//        userDb.deleteUserByName(3);
//
//        userDb.getFirstName();
//        userDb.getLastName();
//        ticketDb.getPrice();
//        ticketDb.setPrice(1000);


    }
}
