package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//        int i ;//i - змінна типу int
//        reflection.User u;//u - змінна типу reflection.User
//        Class c;//c - змінна типу Class

//        reflection.User u1 = new reflection.User("Ivan", "Ivan");
//        reflection.User u2 = reflection.User.createUser("Petr", "Petrov");

        //1
//        try {
//
//            Class<?> class1 = Class.forName("reflection.User");
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("finish");
        //2
//        User user = new User("Ivan", "Ivanov");
//        Ticket ticket = new Ticket(100, "ACDC");
//        Class<? extends User> class2 = ticket.getClass();
        //3
//        System.out.println(int.class);
//        System.out.println(String.class);
//        System.out.println(boolean.class);
//        User user = new User("Ivan", "Ivanov");
//        System.out.println(user.toString());
//        Class class3 = User.class;
//        System.out.println(class3.toString());

        //Class<User> class3 = SuperUser.class;
//        Class<User> class3 = User.class;


        Class<User> userClass = User.class;
//        Method[] methods = userClass.getMethods();
//        for (Method method : methods) {
//            System.out.println(method);
//        }

//        Method[] methods = userClass.getDeclaredMethods();
//        Stream.of(methods).forEach(System.out::println);


//        try {
//            //Method method = userClass.getDeclaredMethod("privateMethod");
//            Method method = userClass.getDeclaredMethod("privateMethod", String.class, int.class);
//            System.out.println(method);
//        } catch (NoSuchMethodException e) {
//            throw new RuntimeException(e);
//        }

//        Constructor[] constructors = userClass.getDeclaredConstructors();
//        for (Constructor constructor : constructors) {
//            System.out.println(constructor);
//        }


    }
}
