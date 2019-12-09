package extend;

import java.io.Serializable;

public class Employee implements Serializable {

    private String name;
    private Integer id,age;
    private String firstName,lastName;
    private Department department;
    public Employee(int id,int age,String name){
        this.id = id;
        this.age=age;
        this.name=name;
    }
    public Employee(int id,int age,String firstName, String lastName){
        this.id = id;
        this.age=age;
        this.firstName=firstName;
        this.lastName=lastName;
    }

    public Employee(int id, String firstName, String lastName, Department department) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

}
