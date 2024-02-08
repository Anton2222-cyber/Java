package edu.itstep.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class CountryPresidentApp {
    private SessionFactory sessionFactory;

    private Session session;
    private List<Country> countryList;
    private List<President> presidentList;

    public CountryPresidentApp() {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Country.class)
                .addAnnotatedClass(President.class)
                .buildSessionFactory();
        session = sessionFactory.getCurrentSession();
    }

    private void addCountryAndPresident() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть назву країни: ");
        String countryName = scanner.nextLine();
        System.out.print("Введіть населення країни: ");
        String populationInput = scanner.nextLine();
        long population = Long.parseLong(populationInput.replaceAll(",", ""));
        System.out.print("Введіть мову країни: ");
        String language = scanner.nextLine();
        System.out.print("Введіть площу країни: ");
        double area = scanner.nextDouble();
        scanner.nextLine(); // чистимо буфер після nextDouble()
        System.out.print("Введіть форму правління країни: ");
        String governmentForm = scanner.nextLine();

        System.out.print("Введіть ім'я президента: ");
        String firstName = scanner.nextLine();
        System.out.print("Введіть прізвище президента: ");
        String lastName = scanner.nextLine();
        System.out.print("Введіть рік народження президента: ");
        int yearOfBirth = scanner.nextInt();

        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Country country = new Country(countryName, population, language, area, governmentForm);
            President president = new President(firstName, lastName, yearOfBirth, country);

            session.save(country);
            session.save(president);

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
            countryList = session.createQuery("from Country").getResultList();
            presidentList = session.createQuery("from President").getResultList();
            session.getTransaction().commit();

            if (countryList.size() == 0) {
                System.out.println("Довідник країн порожній!");
            } else {
                int i = 0;
                for (Country country : countryList) {
                    System.out.println("Країна " + (++i) + ": " + country);
                    for (President president : presidentList) {
                        if (president.getCountry().getId() == country.getId()) {
                            System.out.println("  Президент: " + president);
                        }
                    }
                }
            }

            // Очищаємо сесію, щоб уникнути дублювання
            //session.clear();
        } finally {
            // Закриваємо сесію, щоб уникнути винятків
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    private void editPresidentData() {
        Scanner scanner = new Scanner(System.in);

        // Отримуємо свіжий список президентів з бази даних
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            presidentList = session.createQuery("from President").getResultList();
            session.getTransaction().commit();
        } finally {
            // Закриваємо сесію, щоб уникнути винятків
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        // Виводимо список президентів для вибору
        System.out.println("Список президентів:");
        for (int i = 0; i < presidentList.size(); i++) {
            System.out.println((i + 1) + ". " + presidentList.get(i).getFirstName() + " " + presidentList.get(i).getLastName()+" <"+presidentList.get(i).getCountry().getCountryName()+">");
        }

        System.out.print("Виберіть номер президента, для якого хочете змінити дані: ");
        int presidentIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // очищаємо буфер після nextInt()

        if (presidentIndex < 0 || presidentIndex >= presidentList.size()) {
            System.out.println("Некоректний вибір президента.");
            return;
        }

        President selectedPresident = presidentList.get(presidentIndex);

        boolean continueEditing = true;

        do {
            System.out.println("Оберіть яку інформацію хочете змінити:");
            System.out.println("1. Ім'я");
            System.out.println("2. Прізвище");
            System.out.println("3. Рік народження");
            System.out.println("0. Завершити редагування");

            System.out.print("-> ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // очищаємо буфер після nextInt()

            switch (choice) {
                case 1:
                    System.out.print("Введіть нове ім'я: ");
                    selectedPresident.setFirstName(scanner.nextLine());
                    break;
                case 2:
                    System.out.print("Введіть нове прізвище: ");
                    selectedPresident.setLastName(scanner.nextLine());
                    break;
                case 3:
                    System.out.print("Введіть новий рік народження: ");
                    int newYearOfBirth = scanner.nextInt();
                    scanner.nextLine(); // очищаємо буфер після nextInt()
                    selectedPresident.setYearOfBirth(newYearOfBirth);
                    break;
                case 0:
                    continueEditing = false;
                    break;
                default:
                    System.out.println("Некоректний вибір.");
                    break;
            }
        } while (continueEditing);

        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            // Оновлюємо дані президента
            session.update(selectedPresident);

            session.getTransaction().commit();
            System.out.println("Дані президента змінено.");
        } finally {
            // Закриваємо сесію, щоб уникнути винятків
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }



    public void startWork() {
        Scanner scanner = new Scanner(System.in);
        int choice = 1;
        while (choice != 0) {
            System.out.println("Додати країну та президента ->1\nПодивитися усі ->2\nРедагувати президента країни->3\nВихід ->0");
            System.out.print("->");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addCountryAndPresident();
                    break;
                case 2:
                    showAll();
                    break;
                case 3:
                    editPresidentData();
                    break;
            }
        }
    }

}
