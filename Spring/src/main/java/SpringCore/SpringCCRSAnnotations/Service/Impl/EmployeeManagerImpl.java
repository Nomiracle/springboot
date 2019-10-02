package SpringCore.SpringCCRSAnnotations.Service.Impl;

import SpringCore.SpringCCRSAnnotations.DAO.EmployeeDAO;
import SpringCore.SpringCCRSAnnotations.Service.EmployeeManager;
import SpringCore.SpringStaticfactory.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("employeeManager")
public class EmployeeManagerImpl implements EmployeeManager {

    @Autowired
    EmployeeDAO dao;

    @Override
    public EmployeeDTO createEmployee() {
        return dao.createEmployee();
    }
}
