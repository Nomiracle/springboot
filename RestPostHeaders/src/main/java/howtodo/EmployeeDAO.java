package howtodo;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Repository
public class EmployeeDAO {
    private static Employees list = new Employees();

    static {
        List<Employee>employeeList = new LinkedList<>(Arrays.asList(
                new Employee(1,"Lokesh"),
                new Employee(2, "Alex"),
                new Employee(3, "David")));
        list.setEmployee(employeeList);
    }
    public Employees getAllEmployees(){
        return list;
    }
    void addEmployee(Employee employee){
        List<Employee>employeeList=list.getEmployeeList();
        employeeList.add(employee);
    }
}
