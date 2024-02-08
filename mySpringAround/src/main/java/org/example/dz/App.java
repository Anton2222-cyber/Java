package org.example.dz;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {


        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);


        User user = context.getBean(User.class);


        user.setFirstName("Ivan");
        user.setFirstName("Petr");
        user.setLastName("Ivanov");


        context.close();
    }
}
