package edu.itstep.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
public class ExamStudentApp {
    private SessionFactory sessionFactory;

    private Session session;
    private List<Exam> examList;
    private List<Student> studentList;

    public ExamStudentApp() {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Exam.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        session = sessionFactory.getCurrentSession();
    }
    private void addExam() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть назву екзамену: ");
        String examName = scanner.nextLine();
        System.out.print("Введіть дату та час екзамену (yyyy-MM-dd HH:mm): ");
        String examDatetimeString = scanner.nextLine();
        LocalDateTime examDatetime = LocalDateTime.parse(examDatetimeString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        System.out.print("Введіть адресу екзамену: ");
        String examAddress = scanner.nextLine();

        Exam newExam = new Exam();
        newExam.setExamName(examName);
        newExam.setExamDatetime(examDatetime);
        newExam.setExamAddress(examAddress);

        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            // Додаємо новий екзамен в базу даних
            session.save(newExam);

            session.getTransaction().commit();
            System.out.println("Екзамен додано успішно.");
        } finally {
            // Закриваємо сесію, щоб уникнути винятків
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    private void addStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть ім'я студента: ");
        String firstName = scanner.nextLine();
        System.out.print("Введіть прізвище студента: ");
        String lastName = scanner.nextLine();
        System.out.print("Введіть номер школи студента: ");
        int schoolNumber = scanner.nextInt();

        Student newStudent = new Student();
        newStudent.setFirstName(firstName);
        newStudent.setLastName(lastName);
        newStudent.setSchoolNumber(schoolNumber);

        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            // Додаємо нового студента в базу даних
            session.save(newStudent);

            session.getTransaction().commit();
            System.out.println("Студента додано успішно.");
        } finally {
            // Закриваємо сесію, щоб уникнути винятків
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    private void registerStudentForExam() {
        Scanner scanner = new Scanner(System.in);

        // Отримуємо свіжий список екзаменів і студентів з бази даних
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            // Modify the HQL query to eagerly fetch students
            examList = session.createQuery("SELECT DISTINCT e FROM Exam e LEFT JOIN FETCH e.students").getResultList();
            studentList = session.createQuery("FROM Student").getResultList();

            session.getTransaction().commit();
        } finally {
            // Закриваємо сесію, щоб уникнути винятків
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        // Виводимо список екзаменів та студентів для вибору
        System.out.println("Список екзаменів:");
        for (int i = 0; i < examList.size(); i++) {
            System.out.println((i + 1) + ". " + examList.get(i).getExamName() + " " + examList.get(i).getExamDatetime());
        }

        System.out.println("Список студентів:");
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println((i + 1) + ". " + studentList.get(i).getFirstName() + " " + studentList.get(i).getLastName());
        }

        System.out.print("Виберіть номер екзамену: ");
        int examIndex = scanner.nextInt() - 1;
        System.out.print("Виберіть номер студента: ");
        int studentIndex = scanner.nextInt() - 1;

        if (examIndex < 0 || examIndex >= examList.size() || studentIndex < 0 || studentIndex >= studentList.size()) {
            System.out.println("Некоректний вибір екзамену або студента.");
            return;
        }

        Exam selectedExam = examList.get(examIndex);
        Student selectedStudent = studentList.get(studentIndex);

        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            // Додаємо студента до списку студентів, що приймають участь у екзамені
            if (selectedExam != null && selectedExam.getStudents() != null) {
                selectedExam.getStudents().add(selectedStudent);
                session.saveOrUpdate(selectedExam);
                System.out.println("Студент зареєстрований на екзамен.");
            } else {
                System.out.println("Екзамен або список студентів є нульовим.");
            }

            session.getTransaction().commit();
        } catch (Exception e) {
            // Обробка винятків
            e.printStackTrace();
        } finally {
            // Закриваємо сесію, щоб уникнути винятків
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
    private void displayStudentsAndExams() {
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            // Modify the HQL query to eagerly fetch exams for each student
            studentList = session.createQuery("SELECT DISTINCT s FROM Student s LEFT JOIN FETCH s.exams").getResultList();

            session.getTransaction().commit();
        } finally {
            // Закриваємо сесію, щоб уникнути винятків
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        // Виводимо список студентів та їх зареєстрованих екзаменів
        System.out.println("Список студентів та їх зареєстрованих екзаменів:");
        for (Student student : studentList) {
            System.out.println("Студент: " + student.getFirstName() + " " + student.getLastName());

            if (student.getExams() != null && !student.getExams().isEmpty()) {
                System.out.println("Зареєстровані екзамени:");
                for (Exam exam : student.getExams()) {
                    System.out.println("- " + exam.getExamName() + " " + exam.getExamDatetime());
                }
            } else {
                System.out.println("Студент не зареєстрований на жоден екзамен.");
            }

            System.out.println("--------------------");
        }
    }



    public void startWork() {
        Scanner scanner = new Scanner(System.in);
        int choice = 1;
        while (choice != 0) {
            System.out.println("Зареєструвати студента на екзамен ->1\nДодати екзамен ->2\nДодати студента ->3\nВивести студентів та їх зареєстровані екзамени ->4\nВихід ->0");
            System.out.print("->");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    registerStudentForExam();
                    break;
                case 2:
                    addExam();
                    break;
                case 3:
                    addStudent();
                    break;
                case 4:
                    displayStudentsAndExams();
                    break;
            }
        }
    }
}
