package jcf;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        long start, end = 0;
        //arraylist vs linkedlist
        List<Integer> arrayList = new ArrayList<>();
        start = System.currentTimeMillis();
        for (int i = 1; i <= 500_000; i++) {
            arrayList.add(0, i);
        }
        end = System.currentTimeMillis();
        System.out.println(end - start);//23773

        List<Integer> linkedList = new LinkedList<>();
        start = System.currentTimeMillis();
        for (int i = 1; i <= 500_000; i++) {
            linkedList.add(0, i);
        }
        end = System.currentTimeMillis();
        System.out.println(end - start);//106

        start = System.currentTimeMillis();
        System.out.println(arrayList.get(250_000));
        end = System.currentTimeMillis();
        System.out.println(end - start);//0

        start = System.currentTimeMillis();
        System.out.println(linkedList.get(250_000));
        end = System.currentTimeMillis();
        System.out.println(end - start);//3


    }
}
