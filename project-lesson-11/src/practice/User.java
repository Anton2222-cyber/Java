package practice;

public class User {
    @PrinterAllow
    private String firstName;
    @PrinterAllow(value = true)
    private String lastName;
    @PrinterAllow(value = false)
    private String email;
    private String phone;//-

    public User(String firstName, String lastName, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

}
