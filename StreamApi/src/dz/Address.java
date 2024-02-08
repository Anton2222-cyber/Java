package dz;

public class Address {
    private String city;
    private String street;
    private String home;
    private String room;

    public Address(String city, String street, String home, String room) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.room = room;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHome() {
        return home;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", home='" + home + '\'' +
                ", room='" + room + '\'' +
                '}';
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
