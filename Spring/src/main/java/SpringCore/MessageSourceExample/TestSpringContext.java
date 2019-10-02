package SpringCore.MessageSourceExample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

public class TestSpringContext {
    public static void main(String[] args) throws  Exception{
        ApplicationContext applicationContext
                = new ClassPathXmlApplicationContext
                ("SpringCore/MessageSourceExample/applicationContext.xml");
        String message = applicationContext.getMessage("msg.text",null, Locale.US);
        System.out.println(message);
    }
}
