package dz;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Address address1 = new Address("Київ", "Street1", "123", "RoomA");
        Address address2 = new Address("City2", "Street2", "456", "RoomB");
        Address address3 = new Address("Київ", "Street3", "789", "RoomC");


        User user1 = new User("John Doe", 30, "Male", "john@gmail.com", "Country1");
        User user2 = new User("Jane Smith", 15, "Female", "jane@example.com", "Country2");
        User user3 = new User("Alice Johnson", 35, "Female", "alice@gmail.com", "Country3");
        User user4 = new User("Bob Brown", 28, "Male", "bob@example.com", "Country4");


        Employee employee1 = new Employee("Mike Johnson", 18, "Male", "mike@example.com",
                "Україна", 50000, "Designer", "IT", address1);

        Employee employee2 = new Employee("Emily Brown", 28, "Female", "emily@example.com",
                "Україна", 45000, "Designer", "Engineering", address2);

        Employee employee3 = new Employee("David Lee", 25, "Male", "david@example.com",
                "Україна", 60000, "Supervisor", "Engineering", address3);


        ArrayList<Object> usersAndEmployees = new ArrayList<>();
        usersAndEmployees.add(user1);
        usersAndEmployees.add(user2);
        usersAndEmployees.add(user3);
        usersAndEmployees.add(user4);
        usersAndEmployees.add(employee1);
        usersAndEmployees.add(employee2);
        usersAndEmployees.add(employee3);
        //Получить новый arraylist только с пользователями (экземпляры класса User, не Employee);
        List<User> usersOnly = usersAndEmployees.stream()
                .filter(obj -> obj instanceof User && !(obj instanceof Employee)) // Фильтрация объектов типа User, исключая Employee
                .map(obj -> (User) obj) // Приведение объектов к типу User
                .collect(Collectors.toList()); // Сбор отфильтрованных объектов в новый ArrayList типа User

//        for (User user : usersOnly) {
//            System.out.println(user);
//        }
        //Получить средний возраст среди несовершеннолетних сотрудников;
        List<Employee> minorEmployees = usersAndEmployees
                .stream()
                .filter(obj -> obj instanceof Employee)
                .map(obj -> (Employee) obj)
                .filter(employee -> employee.getAge() < 18)
                .collect(Collectors.toList());
        double averageAgeOfMinors = 0.0;
        if (!minorEmployees.isEmpty()) {
            double totalAge = minorEmployees.stream()
                    .mapToInt(Employee::getAge)
                    .sum();
            averageAgeOfMinors = totalAge / minorEmployees.size();
        }

        System.out.println("Средний возраст несовершеннолетних сотрудников: " + averageAgeOfMinors);
        // Получить коллекцию всех разработчиков, которые проживают в городе Киев
        List<Employee> employeesWhoLiveInKiev = usersAndEmployees
                .stream()
                .filter(obj -> obj instanceof Employee)
                .map(obj -> (Employee) obj)
                .filter(employee -> {
                    Address address = employee.getAddress();
                    return address != null && address.getCity().equals("Київ");
                })
                .collect(Collectors.toList());
//        for (User employee : employeesWhoLiveInKiev) {
//            System.out.println(employee);
//        }

        //- Получить коллекцию названий городов всех дизайнеров
        List<String> cities = usersAndEmployees.stream()
                .filter(obj -> obj instanceof Employee)
                .map(obj -> (Employee) obj)
                .filter(employee -> employee.getPosition().equals("Designer"))
                .filter(employee -> {
                    Address address = employee.getAddress();
                    return address != null && address.getCity() != null;
                })
                .map(employee -> employee.getAddress().getCity())
                .collect(Collectors.toList());

//        for (String city : cities) {
//            System.out.println(city);
//        }
        //Получить коллекцию пользователей у которых почта "gmail.com";
        List<User> usersWithGmail = usersAndEmployees
                .stream()
                .filter(obj -> obj instanceof User)
                .map(obj -> (User) obj)
                .filter(user -> user.getEmail().endsWith("gmail.com"))
                .collect(Collectors.toList());
//        for (User user : usersWithGmail) {
//            System.out.println(user);
//        }

//        - Получить коллекцию электронных почт всех совершеннолетних женщин,
//        не старше 30 лет, проживающих в Украине, которые являются сотрудниками.
        List<String> emails = usersAndEmployees
                .stream()
                .filter(obj -> obj instanceof Employee)
                .map(obj -> (Employee) obj)
                .filter(employee ->
                        employee.getAge() <= 30 &&
                                employee.getAge() >= 18 &&
                                employee.getSex().equalsIgnoreCase("female") &&
                                employee.getCountry().equalsIgnoreCase("Україна") &&
                                employee.getEmail() != null
                )
                .map(Employee::getEmail)
                .collect(Collectors.toList());
//        for (String email : emails) {
//            System.out.println(email);
//        }

        //- Получить средние оклады по каждому отделу
        Map<String, Double> averageSalariesByDepartment = usersAndEmployees.stream()
                .filter(obj -> obj instanceof Employee)
                .map(obj -> (Employee) obj)
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

        for (Map.Entry<String, Double> entry : averageSalariesByDepartment.entrySet()) {
            System.out.println("Отдел: " + entry.getKey() + ", Средний оклад: " + entry.getValue());
        }
    }
}
