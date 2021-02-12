package bestpractices.executorframework;

import bestpractices.executorframework.task.TestOne;
import bestpractices.executorframework.task.TestTwo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class multiracial {


    public static void main(String[] args) {
        BlockingQueue<Runnable> workQueue =
                new ArrayBlockingQueue<>(10);
        RejectedExecutionHandler rejectedExecutionHandler
                = new RejectedExecutionHandlerImp();
        ThreadPoolExecutor executor
                = new ThreadPoolExecutor(3, 3,10,
                TimeUnit.SECONDS, workQueue,rejectedExecutionHandler);
        executor.prestartAllCoreThreads();

        List<Runnable>taskGroup = new ArrayList<>();
        taskGroup.add(new TestOne());
        taskGroup.add(new TestTwo());

        workQueue.add(new MultiRunnable(taskGroup));

    }

}
class MultiRunnable implements Runnable{

    private final List<Runnable> runnables;

    MultiRunnable(List<Runnable> runnables) {
        this.runnables = runnables;
    }

    @Override
    public void run() {
        for (Runnable runnable:runnables){
            new Thread(runnable).start();
        }
    }
}
class RejectedExecutionHandlerImp
        implements RejectedExecutionHandler{

    @Override
    public void rejectedExecution(Runnable r,
                                  ThreadPoolExecutor executor) {
        System.out.println(r.toString() + " : I've been rejected ! ");
    }
}
