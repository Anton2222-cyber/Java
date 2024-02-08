package edu.itstep.mvc.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    @Size(min = 2, message = "First name should have at least {min} characters")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "First name should only contain Latin letters")
    @NotBlank(message = "This field must not be empty")
    private String firstName;

    @Column(name = "last_name")
    @Size(min = 2, max = 20, message = "Last name is not correct...")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Last name should only contain Latin letters")
    @NotBlank(message = "This field must not be empty")
    private String lastName;

    @Column(name = "age")
    @NotNull(message = "This field must not be empty")
    @Digits(integer = 10, fraction = 0, message = "Please enter a valid age")
    @Min(value = 18, message = "Age must be 18 or older")
    private Integer age;
    @Column(name = "marital_status")
    private boolean maritalStatus;
    @Column(name = "gender")
    private boolean gender;

    @Column(name = "phone")
    @Pattern(regexp = "^0\\d{2}-\\d{3}-\\d{2}-\\d{2}$", message = "Phone number should be in the format 0XX-XXX-XX-XX")
    private String phone;

    @Column(name = "email", unique = true)
    @Email(message = "Invalid email format")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Invalid email format. It should follow a valid pattern.")
    private String email;
    public User() {
    }

    public User(String firstName, String lastName, Integer age, boolean maritalStatus, boolean gender, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.maritalStatus = maritalStatus;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(boolean maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && maritalStatus == user.maritalStatus && gender == user.gender && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(age, user.age) && Objects.equals(phone, user.phone) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, age, maritalStatus, gender, phone, email);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", maritalStatus=" + maritalStatus +
                ", gender=" + gender +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
