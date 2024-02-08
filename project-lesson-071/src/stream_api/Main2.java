package stream_api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        //отримати імена тільки дизайнерів відсортировані в зворотному порядку
        List<Human> humans = DataBase.getAll();
//        List<String> names = new ArrayList<>();
//        for (Human human : humans) {
//            if (human.getSpeciality() == Speciality.DESIGNER) {
//                names.add(human.getName());
//            }
//        }
//        Collections.sort(names, (h1, h2) -> h2.compareTo(h1));
//        for (String name : names) {
//            System.out.println(name);
//        }

        List<String> names = humans
                .stream()
                .filter(human -> human.getSpeciality() == Speciality.DESIGNER)
                .map(Human::getName)
                .sorted(Comparator.reverseOrder())
                .toList();
        names.forEach(System.out::println);
    }
}
