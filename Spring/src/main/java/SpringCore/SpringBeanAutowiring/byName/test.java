package SpringCore.SpringBeanAutowiring.byName;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] args) {
        ApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("SpringCore/SpringBeanAutowiring/byName/applicationContext.xml");
        EmployeeBean employee = (EmployeeBean)applicationContext.getBean("employee");
        System.out.println(employee.getFullName());
        System.out.println(employee.getDepartmentBean().getName());
    }
}
