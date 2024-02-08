package edu.itstep.hibernate.one_to_one_uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(EmployeeFullInfo.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        //CREATE
//        Employee employee = new Employee(
//                "Ivan",
//                "Ivanov",
//                "+38-066-666-66-66",
//                "DEVELOPER"
//        );
//        EmployeeFullInfo employeeFullInfo = new EmployeeFullInfo(
//            "ivan@gmail.com",
//                "Ukraine",
//                "Lviv",
//                "Bondara 143 34",
//                true,
//                "1990/11/23"
//        );
//        employee.setEmployeeFullInfo(employeeFullInfo);
//        Employee employee = new Employee(
//                "Petr",
//                "Petrov",
//                "+38-077-777-77-77",
//                "DEVELOPER"
//        );
//        EmployeeFullInfo employeeFullInfo = new EmployeeFullInfo(
//                "petr@gmail.com",
//                "Ukraine",
//                "Lviv",
//                "Peremoga 456 12",
//                true,
//                "1996/03/35"
//        );
//        employee.setEmployeeFullInfo(employeeFullInfo);
//        session.save(employee);

        //READ
//        Employee employee = session.get(Employee.class,2);
//        System.out.println(employee.getFirstName());
//        System.out.println(employee.getEmployeeFullInfo().getAddress());
//        EmployeeFullInfo employeeFullInfo = session.get(EmployeeFullInfo.class, 1);
//        System.out.println(employeeFullInfo.getAddress());

        //UPDATE
//        Employee employee = session.get(Employee.class,1);
//        employee.setPhone("+38-099-999-99-99");
//        employee.getEmployeeFullInfo().setMarried(false);

        //DELETE
//        Employee employee = session.get(Employee.class, 2);
//        session.delete(employee);

        session.getTransaction().commit();
    }
}

//one to one -> eager
//one to many -> lazy
//many to one -> eager
//many to many -> lazy
