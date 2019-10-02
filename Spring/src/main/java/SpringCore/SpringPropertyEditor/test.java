package SpringCore.SpringPropertyEditor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(
                "SpringCore/SpringPropertyEditor/beans.xml"
        );
        DateTest dateTest= (DateTest)applicationContext.getBean("dateTest");
        System.out.println(dateTest.getDateOfBirth());

    }
}
