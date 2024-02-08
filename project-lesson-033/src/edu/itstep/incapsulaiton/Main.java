package edu.itstep.incapsulaiton;

import edu.itstep.oop.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        User user = new User();
//        System.out.println(user.publicField);
//        System.out.println(user.packagePrivate);
//        System.out.println(user.privateField);
//        System.out.println(user.protectedField);

//        int[] arr = {1, 2, 3, 4, 5};
//        System.out.println(arr.length);
//        arr.length = 7;//завдяки інкапсуляції нема доступа


//        System.out.println("Hello World");

        Product product = new Product();
//        product.price = -150;
//        System.out.println(product.price);
        product.setPrice(-150);
        System.out.println(product.getPrice());

//        Scanner scanner = new Scanner();
    }
}
