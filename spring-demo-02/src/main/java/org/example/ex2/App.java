package org.example.ex2;

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
//
//        userDb.checkAge();
//        ticketDb.checkPrice();

        userDb.addUser();
        userDb.getUserById();
        userDb.deleteUserByName(3);

        userDb.getFirstName();
        userDb.getLastName();
        ticketDb.getPrice();
        ticketDb.setPrice(1000);


    }
}
