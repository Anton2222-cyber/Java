package edu.itstep.polymorphism;

public class Main {
    public static void main(String[] args) {
//        System.out.println(1 + 1);
//        System.out.println(1 + "1");

        sum(2,2);
        sum(1,1,1);
    }

    public static void sum(int a, int b) {
        System.out.println("first");
    }

    public static void sum(int a, int b, int c) {
        System.out.println("second");
    }
}
