package SpringCore.SpringConfigurationAnnotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
    @Bean(name="demoService")
    public DemoManager helloWorld(){
        return new DemoManagerImpl();
    }
    @Bean
    public DemoManager helloWorld1(){
        return new DemoManagerImpl("second.");
    }

}
