package edu.itstep.hibernate.one_to_one_uni;

import javax.persistence.*;

@Entity
@Table(name="employees_full_info")
public class EmployeeFullInfo {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "email")
    private String email;
    @Column(name = "country")
    private String country;
    @Column(name = "city")
    private String city;
    @Column(name = "address")
    private String address;
    @Column(name = "is_married")
    private boolean isMarried;
    @Column(name = "date_of_birth")
    private String dateOfBirth;
    @Column(name="count_children")
    private int countChildren;

    public EmployeeFullInfo() {
    }

    public EmployeeFullInfo(String email, String country, String city, String address, boolean isMarried, String dateOfBirth) {
        this.email = email;
        this.country = country;
        this.city = city;
        this.address = address;
        this.isMarried = isMarried;
        this.dateOfBirth = dateOfBirth;
    }

    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isMarried() {
        return isMarried;
    }

    public void setMarried(boolean married) {
        isMarried = married;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
