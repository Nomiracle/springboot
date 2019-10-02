package Async.RestApi;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="employees")
public class EmployeeListVO implements Serializable,Cloneable {
    private List<EmployeeVO>employees
            = new ArrayList<>();
    public List<EmployeeVO>getEmployees(){
        return employees;
    }
     public void setEmployees(List<EmployeeVO>employees){
        this.employees = employees;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        EmployeeListVO employeeList = (EmployeeListVO)super.clone();
        List<EmployeeVO>employeesTmp
                = new ArrayList<>();
        for(EmployeeVO employee : employees){
            employeesTmp.add(employee);
        }
        employeeList.setEmployees(employeesTmp);
        return employeeList;
    }

    @Override
    public String toString() {
        return "EmployeeListVO{" +
                "employees=" + employees +
                '}';
    }
}
