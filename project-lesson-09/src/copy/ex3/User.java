package copy.ex3;

public class User {
    private String name;
    private int age;
    private Address address;

    public User(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public User(User user) {
        this.name = user.name;
        this.age = user.age;
        //this.address = user.address;//problem
        //this.address = new Address(user.address.getStreet(), user.address.getCity());
        this.address = new Address(user.getAddress());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }

    public static User copy(User user) {
        return new User(
                user.name,
                user.age,
                new Address(
                        user.getAddress().getCity(),
                        user.getAddress().getStreet()
                )
        );
    }

}
