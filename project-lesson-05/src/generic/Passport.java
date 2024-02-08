package generic;

public class Passport {
    private String id;

    public Passport(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id='" + id + '\'' +
                '}';
    }
}
