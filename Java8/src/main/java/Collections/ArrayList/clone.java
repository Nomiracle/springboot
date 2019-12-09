package Collections.ArrayList;

import java.util.ArrayList;
import java.util.Date;

class Employee implements Cloneable {

    private Long id;
    private String name;
    private Date dob;       //Mutable field

    public Employee(Long id, String name, Date dob) {
        super();
        this.id = id;
        this.name = name;
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Employee clone = null;
        try
        {
            clone = (Employee) super.clone();

            //Copy new date object to cloned method
            clone.setDob((Date) this.getDob().clone());
        }
        catch (CloneNotSupportedException e)
        {
            throw new RuntimeException(e);
        }
        return clone;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", dob=" + dob + "]";
    }
}
public class clone {
    public static void main(String[] args) throws CloneNotSupportedException {
        ArrayList<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee(1l, "adam", new Date(1982, 02, 12)));

        System.out.println(employeeList);

        ArrayList<Employee> employeeListClone = new ArrayList<>();

        for (Employee employee : employeeList) {
            employeeListClone.add((Employee) employee.clone());
        }

        employeeListClone.get(0).setId(2l);
        employeeListClone.get(0).setName("brian");
        employeeListClone.get(0).getDob().setDate(13);;

        System.out.println(employeeList);
        System.out.println(employeeListClone);
    }
}
