package SpringCore.SpringStaticfactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringStaticFactoryMethod {
    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception
    {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("SpringCore/SpringStaticfactory/application.xml");

        EmployeeDTO manager = (EmployeeDTO) context.getBean("mg");
        System.out.println(manager);

        EmployeeDTO director = (EmployeeDTO) context.getBean("dr");
        System.out.println(director);
    }

}
