package SpringCore.SpringResourceLoader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testCustomResourceLoader {
    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception{
        ApplicationContext application
        = new ClassPathXmlApplicationContext("SpringCore/SpringResourceLoader/applicationContext.xml");

        CustomResourceLoader customResourceLoader
                =(CustomResourceLoader)application.getBean("customResourceLoader");
        customResourceLoader.showResourceData();
    }
}
