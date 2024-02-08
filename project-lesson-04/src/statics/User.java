package statics;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private static int count = 0;

    public User(String firstName, String lastName) {
        this.id = ++count;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static int getCount() {
//        getId();
//        System.out.println(firstName);
        return count;
    }

    public int getId() {
        return id;
    }
}
