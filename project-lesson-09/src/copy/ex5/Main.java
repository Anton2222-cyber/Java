package copy.ex5;

import java.io.*;

public class Main {
    public static void main(String[] args) {

//        User user = new User("Ivan", 18, new Address("Dnipro", "Naberezhna"));
//
//        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("./copy.dat"));
//             ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("./copy.dat"))) {
//
//            outputStream.writeObject(user);
//            User copy = (User) objectInputStream.readObject();
//            copy.setName("Petr");
//            copy.getAddress().setStreet("Abramova");
//
//            System.out.println(user);
//
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
        long start = System.currentTimeMillis();

        User user = new User("Ivan", 18, new Address("Dnipro", "Naberezhna"));
        ByteArrayOutputStream baos = null;
        ObjectOutputStream outputStream = null;
        try {
            baos = new ByteArrayOutputStream();
            outputStream = new ObjectOutputStream(baos);

            outputStream.writeObject(user);

        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ByteArrayInputStream bais = null;
        ObjectInputStream inputStream = null;
        try{
            bais = new ByteArrayInputStream(baos.toByteArray());
            inputStream = new ObjectInputStream(bais);
            User copy = (User) inputStream.readObject();
            copy.setName("Petr");
            copy.getAddress().setStreet("Abramova");
            System.out.println(user);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);//76-83

    }
}
