package practice;

import reflection.Ticket;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) {
        User user = new User("test1", "test1", "test2", "test2");
        Ticket ticket = new Ticket(300, "test2");
        print(user);

    }

    public static void print(Object object) {
        Class<User> userClass = User.class;
        Field[] fields = userClass.getDeclaredFields();
        for (Field field : fields) {
            PrinterAllow printerAllow = field.getAnnotation(PrinterAllow.class);
            if (printerAllow == null) {
                System.out.println(field.getName() + " blocked for print");
                continue;
            }
            if (printerAllow.value()) {
                try {
                    field.setAccessible(true);
                    System.out.println(field.get(object));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
