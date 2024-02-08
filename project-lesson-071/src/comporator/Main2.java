package comporator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Petr", 18));
        users.add(new User("Ivan", 19));
        users.add(new User("121Ivan", 19));
        users.add(new User("Artur", 20));
        users.add(new User("Anton", 32));
        users.add(new User("Anton", 31));
        users.add(new User("Anton", 33));
        users.add(new User("Artem", 33));

        for (User user : users) {
            System.out.println(user);
        }
        System.out.println();
        Collections.sort(users, (o1, o2) -> o1.getFirstName().compareTo(o2.getFirstName()));
    }
}
