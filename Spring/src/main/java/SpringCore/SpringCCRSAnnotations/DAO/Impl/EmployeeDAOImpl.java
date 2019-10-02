package SpringCore.SpringCCRSAnnotations.DAO.Impl;

import SpringCore.SpringCCRSAnnotations.DAO.EmployeeDAO;
import SpringCore.SpringStaticfactory.EmployeeDTO;
import org.springframework.stereotype.Repository;

@Repository("employeeDao")
public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public EmployeeDTO createEmployee() {
        EmployeeDTO e = new EmployeeDTO();
        e.setDesignation("hhhhhhhh");
        e.setId(123);
        e.setFirstName("hhhh");
        e.setLastName("lllll");
        return e;
    }
}
