package SpringCore.SpringAOPAspectJAroundAnnotation;





import SpringCore.SpringStaticfactory.EmployeeDTO;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManagerImpl implements EmployeeManager
{
    public EmployeeDTO getEmployeeById(Integer employeeId)
    {
        System.out.println("Method getEmployeeById() called");
        EmployeeDTO employee = new EmployeeDTO();
        employee.setId(employeeId);
        employee.setFirstName("aaaaaa");
        employee.setDesignation("aaaaaa");
        employee.setLastName("aaaaa");
        return employee;
    }

    public List<EmployeeDTO> getAllEmployee()
    {
        System.out.println("Method getAllEmployee() called");
        return new ArrayList<EmployeeDTO>();
    }

    public void createEmployee(EmployeeDTO employee)
    {
        System.out.println("Method createEmployee() called");
    }

    public void deleteEmployee(Integer employeeId)
    {
        System.out.println("Method deleteEmployee() called");
    }

    public void updateEmployee(EmployeeDTO employee)
    {
        System.out.println("Method updateEmployee() called");
    }
}
