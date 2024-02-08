package stream_api;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Human> humans = DataBase.getAll();
        //Отримати тільки розробників
//        List<Human> developers = new ArrayList<>();
//        for (Human human : humans) {
//            if (human.getSpeciality() == Speciality.DEVELOPER) {
//                developers.add(human);
//            }
//        }
//        for (Human developer : developers) {
//            System.out.println(developer);
//        }

        List<Human> developers = humans
                .stream()
                .filter(human -> human.getSpeciality() == Speciality.DEVELOPER)
                .toList();
        developers.forEach(System.out::println);
    }
}
