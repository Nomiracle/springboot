package JavaConcurrency.CallableFutureExample;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class CallableExample {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor)
                Executors.newFixedThreadPool(2);
        List<Future<Integer>> futureList = new ArrayList<>();
        Random random = new Random();
        long start;
        for(int i=0; i<4 ;i++){
            start = new Date().getTime();
            Integer number = random.nextInt(10);
            FactorialCalculator factorialCalculator
                    = new FactorialCalculator(number);
            Future<Integer>result  = executor.submit(factorialCalculator);
            futureList.add(result);
            System.out.println("Add elements "+number+"to list take "+
                    (new Date().getTime() -start)+" millSecs.");
        }
        int index = 0;
        for(Future<Integer>future : futureList){
             start = new Date().getTime();
            try{
                System.out.println((index++)+", Future result is - "+future.get()+
                        ";And task done is "+future.isDone()+
                        ";take "+(new Date().getTime() -start)+" millSecs.");
            }catch(InterruptedException | ExecutionException e){
                e.printStackTrace();
            }
        }
        executor.shutdown();
    }
}
