package JavaConcurrency.DeadLock;

import JavaConcurrency.DeadLock.resource.A;
import JavaConcurrency.DeadLock.resource.B;

public class DeadLock {
    public static void main(String[] args) {
        final A a = new A();
        final B b = new B();
        Runnable block1 = () -> {
            //-----caused deadlock------------------
//            synchronized (a){
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                synchronized (b){
//                    System.out.println("In block 1....");
//                }
//            }
            //------solution-----------------------
            synchronized (b){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (a){
                    System.out.println("In block 1....");
                }
            }
        };

        Runnable block2 = () -> {
            synchronized (b){
                synchronized (a){
                    System.out.println("In block2...");
                }
            }
        };
        new Thread(block1).start();
        new Thread(block2).start();

    }
}
