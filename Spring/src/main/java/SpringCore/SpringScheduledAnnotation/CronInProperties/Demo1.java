package SpringCore.SpringScheduledAnnotation.CronInProperties;

import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalTime;


public class Demo1 {
    @Scheduled(cron = "${cron.expression}")
    public void demoServiceMethod2(){
        System.out.println(LocalTime.now()+": CronInProperties.demoServiceMethod2");
    }
    public void demoServiceMethod1(){
        System.out.println(LocalTime.now()+": CronInProperties.demoServiceMethod1");
    }




}
