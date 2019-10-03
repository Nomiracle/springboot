package Callable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.ThreadPoolExecutor;

@SpringBootApplication
public class App implements WebMvcConfigurer {
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        configurer.setTaskExecutor(mvcTakExecutor());
        configurer.setDefaultTimeout(30_000);
    }
    @Bean
    public ThreadPoolTaskExecutor mvcTakExecutor(){
        ThreadPoolTaskExecutor taskExecutor
                = new ThreadPoolTaskExecutor();
        taskExecutor.setThreadNamePrefix("mvc-task-");
        return taskExecutor;
    }
}
