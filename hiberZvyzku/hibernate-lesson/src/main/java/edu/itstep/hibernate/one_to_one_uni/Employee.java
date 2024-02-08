package edu.itstep.hibernate.one_to_one_uni;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "phone")
    private String phone;
    @Column(name = "department")
    private String department;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_employees_full_info")
    private EmployeeFullInfo employeeFullInfo;


    public Employee() {
    }

    public Employee(String firstName, String lastName, String phone, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.department = department;
    }

    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }

    public EmployeeFullInfo getEmployeeFullInfo() {
        return employeeFullInfo;
    }

    public void setEmployeeFullInfo(EmployeeFullInfo employeeFullInfo) {
        this.employeeFullInfo = employeeFullInfo;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
