import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        List<Human> humans = DataBase.getAll();
        Map<Speciality, List<Human>> groups = new HashMap<>();
        for (Human human : humans) {
            Speciality speciality = human.getSpeciality();
            if (!groups.containsKey(speciality)) {
                groups.put(speciality, new ArrayList<>());
            }
            groups.get(speciality).add(human);
        }

        for (Map.Entry<Speciality, List<Human>> entry : groups.entrySet()) {
            Speciality speciality = entry.getKey();
            List<Human> humansInGroup = entry.getValue();

            System.out.println(speciality);

            for (Human human : humansInGroup) {
                System.out.println(human);
            }
        }

    }
}
