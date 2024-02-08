package copy.ex4;

public class Main {
    public static void main(String[] args) {
        User original = new User("Artem", 33, new Address("Burgas", "Konstantin Velichkov"));
        User copy = null;
        try {
            copy = (User) original.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }


        copy.setName("Ivan");
        copy.getAddress().setStreet("Karlovo");

        System.out.println(original);
    }
}
