package stream_api;

import java.util.List;
import java.util.function.Predicate;

public class Main1 {
    public static void main(String[] args) {
        List<Human> humans = DataBase.getAll();
        //чи є хоч один неповнолітній?
//        boolean result = false;
//        for (Human human : humans) {
//            if (human.getAge() < 18) {
//                result = true;
//                break;
//            }
//        }
//        System.out.println(result);
        final boolean result = humans
                .stream()
                .anyMatch(human -> human.getAge() < 18);
        System.out.println(result);
    }
}
