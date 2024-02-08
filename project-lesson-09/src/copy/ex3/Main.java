package copy.ex3;

public class Main {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        User original = new User("Artem", 33, new Address("Burgas", "Konstantin Velichkov"));
        User copy = new User(original);

        copy.setName("Ivan");
        copy.getAddress().setStreet("Karlovo");
        System.out.println(original);
        long end = System.currentTimeMillis();
        System.out.println(end-start);//26
    }
}
