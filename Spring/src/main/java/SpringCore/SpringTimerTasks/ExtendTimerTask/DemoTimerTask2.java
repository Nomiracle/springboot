package SpringCore.SpringTimerTasks.ExtendTimerTask;

import java.time.LocalTime;
import java.util.TimerTask;

public class DemoTimerTask2 extends TimerTask {
    @Override
    public void run() {
        System.out.println("DemoTimerTask2 running at: "
                + LocalTime.now());
    }
}
