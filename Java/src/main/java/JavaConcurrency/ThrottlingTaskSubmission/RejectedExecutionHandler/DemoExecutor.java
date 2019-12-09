package JavaConcurrency.ThrottlingTaskSubmission.RejectedExecutionHandler;

import JavaConcurrency.ThrottlingTaskSubmission.DemoTask;

import java.util.concurrent.*;

public class DemoExecutor {
    public static void main(String[] args) {
        int threadCounter = 0;
        BlockingQueue<Runnable>blockingQueue
                = new ArrayBlockingQueue<>(10);
        CustomThreadPoolExecutor executor
                = new CustomThreadPoolExecutor(5,20,
                5000, TimeUnit.MILLISECONDS,blockingQueue);
        executor.setRejectedExecutionHandler(
                (r, executor1) -> {
                    System.out.println("DemoTask Rejected : "+
                            ((DemoTask)r).getName());
                    try{
                        Thread.sleep(1000);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println(
                            "lets add another time : "+
                                    (((DemoTask) r).getName())
                    );
                    executor1.execute(r);
                }
        );
        executor.prestartAllCoreThreads();
        while(true){
            threadCounter++;
            executor.execute(new DemoTask(threadCounter+""));
            if(threadCounter == 300)
                break;
        }
    }
}
