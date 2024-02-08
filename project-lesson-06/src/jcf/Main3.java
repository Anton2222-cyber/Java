package jcf;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main3 {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();
        set.add("one");
        set.add("two");
        set.add("one");
        set.add("three");
        set.add("four");
        set.add("five");
        for (String s : set) {
            System.out.println(s);
        }
//        System.out.println(set.get());
    }
}
