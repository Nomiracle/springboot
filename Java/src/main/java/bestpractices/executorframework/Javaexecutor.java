package bestpractices.executorframework;

import bestpractices.executorframework.task.TestOne;
import bestpractices.executorframework.task.TestTwo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Javaexecutor {
    private static ExecutorService executorService

            ;
    private static volatile Future taskOneResult;
    private static volatile Future taskTwoResult;

    public static void main(String[] args) {
        executorService = Executors.newFixedThreadPool(2);
        while(true){
            try{
                checkTasks();
                Thread.sleep(1000);
            }catch (Exception e){

                e.printStackTrace();
            }
        }
    }
    private static void checkTasks() throws Exception{
        if (taskOneResult == null
                || taskOneResult.isDone()
                || taskOneResult.isCancelled()){
            taskOneResult = executorService.submit(new TestOne());
        }
        if (taskTwoResult == null
                || taskTwoResult.isDone()
                || taskTwoResult.isCancelled()){
            taskTwoResult = executorService.submit(new TestTwo());
        }
    }
}





