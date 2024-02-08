package dz;

public class User {
    private String firstName;
    private String lastName;

    private Ticket ticket;

    public User() {
    }

    public User(String firstName, String lastName, Ticket ticket) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ticket = ticket;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", ticket=" + ticket +
                '}';
    }
}