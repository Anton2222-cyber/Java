package comparable;

public class User implements Comparable<User>{
    private String firstName;
    private int age;

    public User(String firstName, int age) {
        this.firstName = firstName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(User user) {
        return firstName.compareTo(user.firstName);
    }

//    @Override
//    public int compareTo(User user) {
//        if (age < user.age) {
//            return 1;
//        } else if (age > user.age) {
//            return -1;
//        } else {
//            return 0;
//        }
//    }

}
