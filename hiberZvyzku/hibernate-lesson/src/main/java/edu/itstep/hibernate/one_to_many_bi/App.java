package edu.itstep.hibernate.one_to_many_bi;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();


        //CREATE
//        Department department1 = new Department(
//                "DEVELOPER",
//                "HTML, CSS, JavaScript, React, NodeJS",
//                300,
//                5500
//        );
//        Department department2 = new Department(
//                "DESIGNER",
//                "HTML, CSS, Figma, Photoshop",
//                300,
//                4500
//        );
//        Employee employee1 = new Employee("Ivan","Ivanov","+38066-666-66-66",1000);
//        Employee employee2 = new Employee("Petr","Petrov","+38077-777-77-77",3000);
//        Employee employee3 = new Employee("Olga", "Olegovna", "+38088-888-88-88", 1200);
//        department1.addEmployee(employee1);
//        department1.addEmployee(employee2);
//        department2.addEmployee(employee3);
//        session.save(department1);
//        session.save(department2);

        //READ+CREATE
//        Department department = session.get(Department.class, 1);
//        Employee employee = new Employee("Artem", "Udovichenko", "+38066-5-111-626", 4000);
//        department.addEmployee(employee);

        //READ
//        Department department = session.get(Department.class, 1);
//        System.out.println(department.getMaxSalary());
//        System.out.println(department.getEmployees().size());

//        Department department = session.get(Department.class, 1);
//        System.out.println(department);
//        department.getEmployees().forEach(System.out::println);
//        Employee employee = session.get(Employee.class, 1);
//        System.out.println(employee);

        //DELETE
//        Employee employee = session.get(Employee.class, 1);
//        session.delete(employee);

//        Department department = session.get(Department.class, 1);
//        department.getEmployees().forEach(employee -> employee.setDepartment(null));
//        session.delete(department);

        session.getTransaction().commit();

    }
}
//one to one -> eager
//one to many -> lazy
//many to one -> eager
//many to many -> lazy
