package Collections.HashMap.extend;

import Collections.Array.extend.Department;

import java.io.Serializable;
import java.time.LocalDate;

public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String firstName;
    private String lastName;
    private LocalDate localDate;

    public Employee(int id, String fName, LocalDate localDate) {
        super();
        this.id = id;
        this.firstName = fName;
        this.localDate = localDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", localDate=" + localDate +
                '}';
    }
}
