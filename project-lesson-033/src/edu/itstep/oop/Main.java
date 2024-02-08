package edu.itstep.oop;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        System.out.println(user.publicField);
        System.out.println(user.packagePrivate);
//        System.out.println(user.privateField);
        System.out.println(user.protectedField);
    }
}
