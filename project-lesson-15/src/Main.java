import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       // Db.createUsersTable();
//        Db.createUser("Petr","Petrov");

//        List<User> users = Db.getAllUsers();
//        users.forEach(System.out::println);
//        Db.deleteUser(1);
//        System.out.println();
//        users = Db.getAllUsers();
//        users.forEach(System.out::println);


//        User user = new User("Stepan", "Stepanov");//Отримали від клієнта
//        Db.createUserOrUpdate(user);

//        User user = new User(2, "new", "new");
//        Db.createUserOrUpdate(user);

        //User user = new User( "new", "new");
        //Db.createUserOrUpdate(user);
        Db.createAddressesTable();
        Db.createUsersTable();


        // Створюємо адресу та отримуємо її ID
        Address address = new Address("вул. Поштова 1", "Київ", "Київська", "Україна", "03050");
        int addressId = Db.createAddress(address); // Викликаємо метод createAddress() з класу Db

        // Створюємо користувачів та прив'язуємо до адреси за допомогою addressId
        User user1 = new User("Іван", "Іванов", new Address(addressId, address.getStreet(), address.getCity(), address.getState(), address.getCountry(), address.getZipCode()));
        User user2 = new User("Петро", "Петров", new Address(addressId, address.getStreet(), address.getCity(), address.getState(), address.getCountry(), address.getZipCode()));
        Db.createUserOrUpdate(user1);
        Db.createUserOrUpdate(user2);

        // Отримуємо всіх користувачів
        List<User> users = Db.getAllUsers();
        users.forEach(System.out::println);

        // Видалення користувача
        Db.deleteUser(1);
    }

}
