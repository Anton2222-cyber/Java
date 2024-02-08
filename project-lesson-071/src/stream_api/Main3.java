package stream_api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main3 {
    public static void main(String[] args) {
        //Сгрупувати людей по спеціальності у різні колекції.
        //Кількість спеціальностей залиежить від Speciality.
        //Результат зберігати в map(ключ-спеціальність, значення-список из Human)
        List<Human> humans = DataBase.getAll();
        Map<Speciality, List<Human>> groups = humans
                .stream()
                .collect(Collectors.groupingBy(Human::getSpeciality));

        groups.forEach(((speciality, group) -> {
            System.out.println(speciality);
            group.forEach(System.out::println);
        }));

        //написати в імперативному стилі(без StreamAPI, без посилань на методи, без лямди).
        //цикли, if-и


    }
}
