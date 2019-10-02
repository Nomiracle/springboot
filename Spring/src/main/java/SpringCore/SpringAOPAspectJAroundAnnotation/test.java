package SpringCore.SpringAOPAspectJAroundAnnotation;

import SpringCore.SpringStaticfactory.EmployeeDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    @SuppressWarnings("resource")
    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("SpringCore/SpringAOPAspectJAroundAnnotation/applicationContext.xml");
        EmployeeManager manager = (EmployeeManager) context.getBean("employeeManager");

        EmployeeDTO employee = manager.getEmployeeById(1);
        System.out.println(employee);
        manager.createEmployee(new EmployeeDTO());
    }
}