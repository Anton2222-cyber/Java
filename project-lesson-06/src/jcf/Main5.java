package jcf;

import java.util.HashMap;
import java.util.Map;

public class Main5 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Zp", 700_000);
        map.put("Dn", 1_500_000);
        map.put("Kv", 500_000);
        map.put("Dn", 2_000_000);
//        System.out.println(map.get("Dn"));

//        for (String s : map.keySet()) {
//            System.out.println(s);
//        }
//        for (Integer value : map.values()) {
//            System.out.println(value);
//        }
        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            System.out.println(pair.getKey() + "-->" + pair.getValue());
        }
    }
}
