package edu.itstep.practice;

public class Main {
    public static void main(String[] args) {
//        int[] arr = new int[3];

        ArrayListInt arrayListInt = new ArrayListInt();
        arrayListInt.add(777);
        arrayListInt.add(123);
        arrayListInt.add(555);

        arrayListInt.print();
        arrayListInt.add(444);
        arrayListInt.add(3);
        arrayListInt.print();

        System.out.println(arrayListInt.getSize());
    }
}
