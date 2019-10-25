package JavaConcurrency.ProducerAndConsumer;

import java.util.List;

public class Consumer implements Runnable {
    private final List<Integer> taskQueue;

    Consumer(List<Integer> taskQueue) {
        this.taskQueue = taskQueue;
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
        while (true) {
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void consume() throws InterruptedException {
        synchronized (taskQueue) {
            System.out.println("start consume:");
            while (taskQueue.isEmpty()) {
                System.out.println("Queue is empty," + Thread.currentThread().getName()
                        + " is waiting, size:" + taskQueue.size());
                taskQueue.wait();
            }
            Thread.sleep(1000);
            int i = taskQueue.remove(0);
            System.out.println("consumed : " + i);
            taskQueue.notifyAll();
            System.out.println("end consume:");
        }
    }
}
