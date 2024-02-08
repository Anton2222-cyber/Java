package jcf;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();

        integers.add(3);
        integers.add(5);
        integers.add(8);

        strings.add("one");
        strings.add("two");
        strings.add("three");

        int res1 = integers.get(0);
        String res2 = strings.get(0);

            System.out.println(integers.size());

//        System.out.println(integers[0]);

    }
}
