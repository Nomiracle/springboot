package SpringCore.SpringScheduledAnnotation.CronInContext;

import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalTime;


public class Demo1 {
    @Scheduled(fixedDelay = 3000)
    public void demoServiceMethod2(){
        System.out.println(LocalTime.now()+": demoServiceMethod2");
    }
    public void demoServiceMethod1(){
        System.out.println(LocalTime.now()+": demoServiceMethod1");
    }



}
