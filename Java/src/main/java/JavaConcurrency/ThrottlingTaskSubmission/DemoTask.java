package JavaConcurrency.ThrottlingTaskSubmission;

public class DemoTask implements Runnable{
    private String name = null;
    public DemoTask(String name){
        this.name = name;
    }

    public String getName() {
        return name;
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
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Executing : "+name);
    }
}
