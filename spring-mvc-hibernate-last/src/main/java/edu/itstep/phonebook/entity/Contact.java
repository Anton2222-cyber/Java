package edu.itstep.phonebook.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
@Entity
@Table(name = "contacts")
public class Contact {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    @Size(min = 2, message = "First name should have at least {min} characters")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "First name should only contain Latin letters")
    private String firstName;

    @Column(name = "last_name")
    @Size(min = 2, message = "Last name should have at least {min} characters")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Last name should only contain Latin letters")
    private String lastName;
    @Column(name = "phone")
    @Pattern(regexp = "^0\\d{2}-\\d{3}-\\d{2}-\\d{2}$", message = "Phone number should be in the format 0XX-XXX-XX-XX")
    private String phone;

    @Column(name = "email", unique = true)
    @Email(message = "Invalid email format")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Invalid email format. It should follow a valid pattern.")
    private String email;

    @Column(name = "marital_status")
    private boolean maritalStatus;

    public Contact() {
    }

    public Contact(String firstName, String lastName, String phone, String email, boolean maritalStatus) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.maritalStatus = maritalStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return id == contact.id && maritalStatus == contact.maritalStatus && Objects.equals(firstName, contact.firstName) && Objects.equals(lastName, contact.lastName) && Objects.equals(phone, contact.phone) && Objects.equals(email, contact.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, phone, email, maritalStatus);
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

    public boolean isMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(boolean maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", maritalStatus=" + maritalStatus +
                '}';
    }
}
