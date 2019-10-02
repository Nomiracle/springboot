package SpringCore.SpringCCRSAnnotations;

import SpringCore.SpringCCRSAnnotations.Controller.EmployeeController;
import SpringCore.SpringCCRSAnnotations.DAO.Impl.EmployeeDAOImpl;
import SpringCore.SpringCCRSAnnotations.Service.Impl.EmployeeManagerImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "SpringCore/SpringCCRSAnnotations/applicationContext.xml");

        //EmployeeManager manager = (EmployeeManager) context.getBean(EmployeeManager.class);

        //OR this will also work

        EmployeeDAOImpl employeeDao = (EmployeeDAOImpl) context.getBean("employeeDao");

        System.out.println(employeeDao.createEmployee());

        EmployeeManagerImpl employeeManager = (EmployeeManagerImpl)context.getBean("employeeManager");
        System.out.println(employeeManager.createEmployee());

        EmployeeController employeeController = (EmployeeController)context.getBean("employeeController");
        System.out.println(employeeController.createEmployee());


    }
}
