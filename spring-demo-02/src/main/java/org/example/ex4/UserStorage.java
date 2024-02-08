package org.example.ex4;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserStorage {
    private List<User> users = new ArrayList<>();

    public UserStorage() {
        init();
    }

    private void init() {
        users.add(new User("Ivan", "Ivanov", 18));
        users.add(new User("Petr", "Petrov", 22));
        users.add(new User("Ivan", "Olegov", 20));
    }

    public List<User> getUsers() {
        System.out.println("start getUsers()");
//        String st = null;
//        System.out.println(st.toUpperCase());
//        System.out.println(3 / 0);
        return users;
    }
}
