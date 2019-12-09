package JavaConcurrency.executorframework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DemoExecutorUsage {
    private static ExecutorService executorService
            = null;
    private static volatile Future taskOneResults = null;
    private static volatile Future  taskTwoResults = null;

    public static void main(String[] args) {
        executorService = Executors.newFixedThreadPool(2);
        while(true){
            try{
                checkTask();
                Thread.sleep(1000);
            }catch(Exception e){
                System.out.println("Caught exeception: "+e.getMessage());
            }
        }
    }

    private static void checkTask() throws Exception{
        if(taskOneResults == null ||
        taskOneResults.isDone()||
        taskOneResults.isCancelled()){
            taskOneResults = executorService.submit(new TestOne());
        }
        if(taskTwoResults == null ||
                taskTwoResults.isDone()||
                taskTwoResults.isCancelled()){
            taskTwoResults = executorService.submit(new TestTwo());
        }
    }
}
class TestOne implements Runnable{

    @Override
    public void run() {
        int i = 0;
       while(true){
           System.out.println("Executing task one");
           try{
               Thread.sleep(1000);
               if( i++ == 10){
                   throw new Exception("there is error!!");
               }
           }catch(Throwable e){
               e.printStackTrace();
           }
       }
    }
}
class TestTwo implements Runnable{

    @Override
    public void run() {
        int i = 0;
        while(true){
            System.out.println("Executing task two");
            try{
                Thread.sleep(1000);
                if( i++ == 10){
                    throw new Exception("there is error!!");
                }
            }catch(Throwable e){
                e.printStackTrace();
            }
        }
    }
}