package SpringCore.BeanPostProcessorExample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
    public static void main(String[] args) {
        ApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("SpringCore/BeanPostProcessorExample/beans.xml");

    }
}
