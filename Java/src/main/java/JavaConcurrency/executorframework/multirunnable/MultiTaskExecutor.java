package JavaConcurrency.executorframework.multirunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MultiTaskExecutor {
    public static void main(String[] args) {
        BlockingQueue<Runnable>workQueue
                = new ArrayBlockingQueue<>(10);
        RejectedExecutionHandler rejectedExecutionHandler
                = new RejectedExecutionHandlerImpl();
        ThreadPoolExecutor executor
                = new ThreadPoolExecutor(3,3,
                10, TimeUnit.SECONDS,workQueue,
                rejectedExecutionHandler);
        executor.prestartAllCoreThreads();
        List<Runnable> taskGroup = new ArrayList<>();
        taskGroup.add(new TaskOne());
        taskGroup.add(new TaskTwo());
        taskGroup.add(new TaskThree());
        workQueue.add(new MultiRunnable(taskGroup));

    }
}
class RejectedExecutionHandlerImpl implements  RejectedExecutionHandler{

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println(r.toString() + ": I have been rejected !");
    }
}