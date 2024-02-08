package reflection;

import java.lang.reflect.Field;

public class Main1 {
    public static void main(String[] args) {
        User user = new User("Ivan", "Ivanov");
//        System.out.println(user.getFirstName());
//        System.out.println(user.firstName);

//        Class<? extends User> userClass = user.getClass();
//        try {
//            Field field = userClass.getDeclaredField("firstName");
//            field.setAccessible(true);
//            System.out.println(field.get(user));
//        } catch (NoSuchFieldException e) {
//            throw new RuntimeException(e);
//        } catch (IllegalAccessException e) {
//            throw new RuntimeException(e);
//        }


    }
}
