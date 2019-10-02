package Async.RestApi;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDB {
    public static EmployeeListVO getEmployeeList()
    {
        List<EmployeeVO> list = new ArrayList<>();

        EmployeeVO empOne = new EmployeeVO(1, "Lokesh", "Gupta", "howtodoinjava@gmail.com");
        EmployeeVO empTwo = new EmployeeVO(2, "Amit", "Singhal", "asinghal@yahoo.com");
        EmployeeVO empThree = new EmployeeVO(3, "Kirti", "Mishra", "kmishra@gmail.com");

        list.add(empOne);
        list.add(empTwo);
        list.add(empThree);

        EmployeeListVO employeeList = new EmployeeListVO();
        employeeList.setEmployees(list);

        return employeeList;
    }
}
