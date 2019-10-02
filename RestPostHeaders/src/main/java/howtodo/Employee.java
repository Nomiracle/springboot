package howtodo;

public class Employee {
    Employee(){}
    Employee(Integer id, String Name) {
        super();
        this.id = id;
        this.Name = Name;
    }

    private String Name;
    private Integer id;

    public Integer getId() {
        return id;
    }

     void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

     void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Name='" + Name + '\'' +
                ", id=" + id +
                '}';
    }
}
