package dz;

public class Employee extends User {
    private int salary;
    private String position;
    private String department;

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                ", position='" + position + '\'' +
                ", department='" + department + '\'' +
                ", address=" + address +
                '}';
    }

    private Address address;

    public Employee(String fullname, int age, String sex, String email, String country, int salary, String position, String department, Address address) {
        super(fullname, age, sex, email, country);
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.address = address;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
