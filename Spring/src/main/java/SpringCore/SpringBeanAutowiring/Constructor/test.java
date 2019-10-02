package SpringCore.SpringBeanAutowiring.Constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] args) {
        ApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("SpringCore/SpringBeanAutowiring/Constructor/applicationContext.xml");
        EmployeeBean employeeBean = (EmployeeBean)applicationContext.getBean("employee");
        System.out.println(employeeBean.getFullName());
        System.out.println(employeeBean.getDepartmentBean().getName());

    }
}
