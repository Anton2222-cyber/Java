package comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        List<Integer> numbers = new ArrayList<>();
//        numbers.add(9);
//        numbers.add(3);
//        numbers.add(7);
//        numbers.add(2);
//        numbers.add(9);
//        for (Integer number : numbers) {
//            System.out.print(number + " ");
//        }
//        System.out.println();
//        Collections.sort(numbers);
//        for (Integer number : numbers) {
//            System.out.print(number + " ");
//        }

//        List<String> names = new ArrayList<>();
//        names.add("Artur");
//        names.add("Petr");
//        names.add("Oleg");
//        names.add("Ivan");
//        names.add("Artem");
//        for (String name : names) {
//            System.out.println(name);
//        }
//        System.out.println();
//        Collections.sort(names);
//        for (String name : names) {
//            System.out.println(name);
//        }


        List<User> users = new ArrayList<>();
        users.add(new User("Artur", 20));
        users.add(new User("Petr", 18));
        users.add(new User("Ivan", 19));
        users.add(new User("121Ivan", 19));
        users.add(new User("Anton", 32));
        users.add(new User("Anton", 31));
        users.add(new User("Anton", 33));
        users.add(new User("Artem", 33));
        for (User user : users) {
            System.out.println(user);
        }
        System.out.println();
        Collections.sort(users);
        for (User user : users) {
            System.out.println(user);
        }
    }
}
