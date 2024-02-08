package jcf;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main1 {
    public static void main(String[] args) {
        List<String> strings = new LinkedList<>();
        strings.add("one");
        strings.add("two");
        strings.add("three");
        System.out.println(strings.size());
//        System.out.println(strings.get(1));
        strings.add(0, "four");
        for (String string : strings) {
            System.out.println(string);
        }
        strings.remove("four");
        System.out.println();
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
