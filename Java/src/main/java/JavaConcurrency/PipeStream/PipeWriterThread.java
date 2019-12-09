package JavaConcurrency.PipeStream;

import java.io.PipedWriter;

public class PipeWriterThread  implements Runnable{
    private PipedWriter pipedWriter;
    private String name;
    PipeWriterThread(PipedWriter pipedWriter,String name){
        this.pipedWriter = pipedWriter;
        this.name = name;
    }
    @Override
    public void run() {
        try{
            while(true){
                pipedWriter.append("Testing data Written...\n");
                pipedWriter.flush();
                Thread.sleep(2000);
            }
        }catch(Exception e){
            System.out.println("PipeThread Exception:"+e);
        }
    }
}
