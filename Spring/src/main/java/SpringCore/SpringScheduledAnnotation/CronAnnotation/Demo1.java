package SpringCore.SpringScheduledAnnotation.CronAnnotation;

import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalTime;


public class Demo1 {
    @Scheduled(cron = "*/5 * * * * ?")
    public void demoServiceCronAnnotationMethod2(){
        System.out.println(LocalTime.now()+": CronAnnotation");
    }
    @Scheduled(fixedRate = 5000)
    public void demoServicefixedRateAnnotationMethod(){
        System.out.println(LocalTime.now()+": fixedRateAnnotation");
    }
    @Scheduled(fixedDelay = 5000)
    public void demoServiceCronAnnotationMethod(){
        System.out.println(LocalTime.now()+": fixedDelayAnnotation");
    }

}
