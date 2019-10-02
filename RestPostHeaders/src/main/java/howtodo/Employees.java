package howtodo;

import java.util.ArrayList;
import java.util.List;

 class Employees {
    private List<Employee> employeeList;
     public List<Employee>getEmployeeList(){
        if(employeeList==null)
            employeeList = new ArrayList<>();
        return employeeList;
    }
     void setEmployee(List<Employee>employeeList){
            this.employeeList=employeeList;
    }

     @Override
     public String toString() {
         return "Employees{" +
                 "employeeList=" + employeeList +
                 '}';
     }
 }
