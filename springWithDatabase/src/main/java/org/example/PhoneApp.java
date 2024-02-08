package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class PhoneApp {
    private SessionFactory sessionFactory;

    private Session session;
    private List<Person> personList;

    public PhoneApp() {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Person.class)
                .buildSessionFactory();
        session = sessionFactory.getCurrentSession();
    }

    private void addPerson() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть ім'я: ");
        String firstName = scanner.nextLine();
        System.out.print("Введіть прізвище: ");
        String lastName = scanner.nextLine();
        System.out.print("Введіть телефон: ");
        String phone = scanner.nextLine();

        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.save(new Person(firstName, lastName, phone));
            session.getTransaction().commit();
        } finally {
            // Закриваємо сесію, щоб уникнути винятків
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    private void showAll() {
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            personList = session.createQuery("from Person").getResultList();
            session.getTransaction().commit();
        if(personList.size()==0){
            System.out.println("Довідник пустий!");
            return;
        }
        int i = 0;
        for (Person person : personList) {
            System.out.println(++i + ". " + person);
        }
        } finally {
            // Закриваємо сесію, щоб уникнути винятків
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

    }

    private void deletePerson(int number) {
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.delete(personList.get(--number));
            personList = session.createQuery("from Person").getResultList();
            session.getTransaction().commit();
        } finally {
            // Закриваємо сесію, щоб уникнути винятків
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

    }

    public void startWork() {
        Scanner scanner = new Scanner(System.in);
        int choise = 1;
        while (choise != 0) {
            System.out.println("Додати контакт ->1\nПодивится усі ->2\nВидалити контакт ->3\nВихід ->0");
            System.out.print("->");
            choise = scanner.nextInt();
            switch (choise) {
                case 1:
                    addPerson();
                    break;
                case 2:
                    showAll();
                    break;
                case 3:
                    if(personList.size()>0){
                        int numForDelete=0;
                        System.out.print("->");
                        numForDelete= scanner.nextInt();
                        while (numForDelete<=0||numForDelete>personList.size()){
                            System.out.println("Некоректний вибір!");
                            System.out.println("->");
                            numForDelete= scanner.nextInt();
                        }
                        deletePerson(numForDelete);

                    }else {
                        System.out.println("Довідник пустий!");
                    }
                    break;
            }
        }


    }
}
