package JavaConcurrency.ThrottlingTaskSubmission.Throttling;

import java.util.concurrent.*;

public class BlockingThreadPoolExecutor extends ThreadPoolExecutor {
   private final Semaphore semaphore;

    public BlockingThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        semaphore = new Semaphore(corePoolSize + 10);
    }


    @Override
    public void execute(Runnable command) {
        boolean acquired = false;
        do {
            try{
                semaphore.acquire();
                acquired = true;
            }catch(InterruptedException e){
                e.printStackTrace();
            }
//            System.out.println(((DemoTask)command).getName()
//            +" acquired : "+acquired);
        }while(!acquired);
        try{
            super.execute(command);
        }catch(RejectedExecutionException e){
            System.out.println("Task Rejected");
            semaphore.release();
            throw e;
        }
    }


    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        if(t!=null){
            t.printStackTrace();
        }
        semaphore.release();
    }
}
