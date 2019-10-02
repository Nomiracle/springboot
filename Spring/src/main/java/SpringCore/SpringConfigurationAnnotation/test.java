package SpringCore.SpringConfigurationAnnotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class test {
    public static void main(String[] args) {
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        DemoManager obj = (DemoManager)applicationContext.getBean("demoService");

        System.out.println(obj.getServiceName());
//        DemoManager obj1 = (DemoManager)applicationContext.getBean("demoManagerImpl");
//        System.out.println(obj1.getServiceName());
    }
}
