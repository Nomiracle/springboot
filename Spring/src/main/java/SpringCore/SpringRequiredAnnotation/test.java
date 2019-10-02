package SpringCore.SpringRequiredAnnotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] args) {
        ApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("SpringCore/SpringRequiredAnnotation/applicationContext.xml");
        EmployeeFactoryBean factoryBean = (EmployeeFactoryBean) applicationContext.getBean("manager");
        System.out.println(factoryBean.getDesignation());
    }
}
