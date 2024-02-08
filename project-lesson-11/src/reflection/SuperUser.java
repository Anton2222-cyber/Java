package reflection;

public class SuperUser extends User {
    private String login;

    public SuperUser(String firstName, String lastName, String login) {
        super(firstName, lastName);
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
