package statics;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Ivan", "Ivanov");
        User user2 = new User("Petr", "Ivanov");
        User user3 = new User("Oleg", "Ivanov");
        User user4 = new User("Oleg", "Ivanov");
        User user5 = new User("test", "test");

        System.out.println(User.getCount());
        System.out.println(user3.getId());
    }
}
