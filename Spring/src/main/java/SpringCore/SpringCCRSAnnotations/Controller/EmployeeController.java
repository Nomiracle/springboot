package SpringCore.SpringCCRSAnnotations.Controller;

import SpringCore.SpringCCRSAnnotations.Service.EmployeeManager;
import SpringCore.SpringStaticfactory.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller("employeeController")
public class EmployeeController {
    @Autowired
    EmployeeManager manager;

    public EmployeeDTO createEmployee()
    {
        return manager.createEmployee();
    }
}
