package JavaConcurrency.ProducerAndConsumer;

import java.util.LinkedList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Integer> taskQueue = new LinkedList<>();
        Thread consumer = new Thread(new Consumer(taskQueue));
        Thread producer = new Thread(new Producer(taskQueue,5));
        producer.start();
        consumer.start();
        consumer.start();
    }
}
