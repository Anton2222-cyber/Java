package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main3 {
    public static void main(String[] args) {
        try {
            Constructor constructor = User.class.getDeclaredConstructor(String.class);
            constructor.setAccessible(true);
            User user = (User) constructor.newInstance("Artem");
            System.out.println(user.lastName);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
