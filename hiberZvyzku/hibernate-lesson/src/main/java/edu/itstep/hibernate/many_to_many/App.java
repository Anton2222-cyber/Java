package edu.itstep.hibernate.many_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class App {
    public static void main(String[] args) throws ParseException {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

//        Section english = new Section("English", 50);
//        Section karate = new Section("Karate", 10);
//        Section it = new Section("IT", 70);
//        Child ivan = new Child(
//                "Ivan",
//                "Ivanov",
//                new SimpleDateFormat("dd-MM-yyyy").parse("12-07-2001"),
//                "+38066-111-11-11"
//        );
//        Child petr = new Child(
//                "Petr",
//                "Petrov",
//                new SimpleDateFormat("dd-MM-yyyy").parse("11-05-2003"),
//                "+38066-222-22-22"
//        );
//        Child olga = new Child(
//                "Olga",
//                "Ivanova",
//                new SimpleDateFormat("dd-MM-yyyy").parse("05-03-2005"),
//                "+38066-333-33-33"
//        );
//        english.addChild(ivan);
//        english.addChild(petr);
//
//        it.addChild(ivan);
//        karate.addChild(olga);
//
//        session.persist(english);
//        session.persist(it);
//        session.persist(karate);

        Section karate = session.get(Section.class, 6);
//        Child ivan = session.get(Child.class, 1);
//        karate.addChild(ivan);
//        session.save(karate);

                Child test = new Child(
                "test",
                "test",
                new SimpleDateFormat("dd-MM-yyyy").parse("05-03-2005"),
                "test"
        );
        karate.addChild(test);
        session.persist(karate);

        session.getTransaction().commit();

    }
}
