package jcf;

import java.util.HashSet;
import java.util.Set;

public class Main4 {
    public static void main(String[] args) {
        Set<User> users = new HashSet<>();
        users.add(new User("Ivan", "Ivanov"));
        users.add(new User("Stepan", "Stepanov"));
        users.add(new User("Petr", "Petrov"));
        users.add(new User("Ivan", "Ivanov"));
        System.out.println(users.size());
        for (User user : users) {
            System.out.println(user);
        }

//        String a = "first";
//        String b = "second";
//        String c = "second";
//        System.out.println(a.hashCode());
//        System.out.println(b.hashCode());
//        System.out.println(c.hashCode());

//        String a = new String("first");
//        String b = new String("second");
//        String c = new String("second");
//        System.out.println(a.hashCode());
//        System.out.println(b.hashCode());
//        System.out.println(c.hashCode());

//        jcf.User user1 = new jcf.User("Ivan", "Ivanov");
//        jcf.User user2 = new jcf.User("Petr", "Petrov");
//        jcf.User user3 = new jcf.User("Ivan", "Ivanov");
//        System.out.println(user1.hashCode());
//        System.out.println(user2.hashCode());
//        System.out.println(user3.hashCode());
//        System.out.println(user1.toString());
//        System.out.println(user2.toString());
//        System.out.println(user3.toString());
    }
}
