package SpringCore.SpringTimerTasks.ConfigureMethodInvokingTimerTaskFactoryBean;

import java.time.LocalTime;

public class DemoTimerTask {
    public void execute(){
        System.out.println("Executed task on :: " + LocalTime.now());
    }
}
