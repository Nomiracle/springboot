package SpringCore.SpringPub2Sub;

import SpringCore.SpringPub2Sub.otherClass.EmployeeController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception{
        ApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("SpringCore/SpringPub2Sub/application.xml");
        EmployeeController employeeController
               = applicationContext.getBean(EmployeeController.class);
        employeeController.createNewEmployee();
    }
}
