package SpringCore.SpringUtilConstant;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] args) {
        ApplicationContext context
                = new ClassPathXmlApplicationContext("SpringCore/SpringUtilConstant/applicationContext.xml");
        EmployeeTypeWrapper employeeTypeWrapper = (EmployeeTypeWrapper) context.getBean("employeeTypeWrapper");

        System.out.println(employeeTypeWrapper.getManager());
        System.out.println(employeeTypeWrapper.getDirector());
        System.out.println((EmployeeDTO)context.getBean("employeeType"));
    }
}
