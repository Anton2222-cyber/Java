package reflection;

public class User {
    private String firstName;
    public String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    private User(String lastName) {
        this.lastName = lastName;
    }

//    public String getFirstName() {
//        return firstName;
//    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static User createUser(String firstName, String lastName) {
        return new User(firstName, lastName);
    }

    private void privateMethod(String test1, int test2) {
        System.out.println("private method");
        System.out.println(test1 + test2);
    }
    private void privateMethod(){
        System.out.println("private method");
    }
    public static void staticMethod(){
        System.out.println("static method");
    }

}
