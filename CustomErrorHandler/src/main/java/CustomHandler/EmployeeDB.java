package CustomHandler;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class EmployeeDB {
    private static List<EmployeeVO>employeeList;
    static {
        employeeList = new ArrayList<>(
                Arrays.asList(
                        new EmployeeVO(1,"jile","hgh","1@qq.com"),
                        new EmployeeVO(2,"hhh","jjjj","2@qq.com")
                )
        );
    }
    EmployeeVO getEmployeeById(int id){
        for(EmployeeVO employee:employeeList){
            if(employee.getEmployeeId() == id)
                return employee;
        }
        return null;
    }

    void addEmployee(EmployeeVO employee){
        int id = employeeList.size()+1;
        employee.setEmployeeId(id);
        employeeList.add(employee);
    }
}
