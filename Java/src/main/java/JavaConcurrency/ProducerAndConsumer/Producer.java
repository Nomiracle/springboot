package JavaConcurrency.ProducerAndConsumer;

import java.util.List;

public class Producer implements Runnable {
    private final List<Integer> taskQueue;
    private final int max_size;

    Producer(List<Integer> taskQueue, int max_size) {
        this.taskQueue = taskQueue;
        this.max_size = max_size;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        int counter = 0;
        while (true) {
            try {
                produce(counter++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void produce(int i) throws InterruptedException {
        synchronized (taskQueue) {
            while (taskQueue.size() == max_size) {
                System.out.println("Queue is full " + Thread.currentThread().getName() +
                        "is waiting , size" + taskQueue.size());
                taskQueue.wait();
            }
            Thread.sleep(1000);
            taskQueue.add(i);
            System.out.println("Produce: " + i);
            taskQueue.notify();
        }

    }
}
