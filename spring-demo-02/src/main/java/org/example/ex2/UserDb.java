package org.example.ex2;

import org.springframework.stereotype.Component;

@Component
public class UserDb {
    public void create(){
        System.out.println("CREATE USER");
    }
    public String getFirstName(){
        System.out.println("getFirstName()");
        return "first name";
    }
    public String getLastName(){
        System.out.println("getLastName");
        return "last name";
    }
    public void checkAge(){
        System.out.println("checkAge");
    }

    public void addUser(){
        System.out.println("addUser");
    }
    public void getUserById(){
        System.out.println("getUserById");

    }
    public void deleteUserByName(int id){
        System.out.println("deleteUserByName");
    }
}
