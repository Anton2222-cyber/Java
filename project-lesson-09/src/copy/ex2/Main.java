package copy.ex2;

public class Main {
    public static void main(String[] args) {
        //problem
        User user = new User("Ivan", 18);
        User copy = new User(user);
        copy.setName("Petr");
        System.out.println(user);
    }
}
