package JavaConcurrency.PipeStream;

import java.io.IOException;
import java.io.PipedReader;

public class PipeReaderThread implements Runnable{
  PipedReader pipedReader;
  String name;
    PipeReaderThread(String name, PipedReader pipedReader){
        this.name = name;
        this.pipedReader = pipedReader;
    }
    @Override
    public void run() {
        try{
            while(true){
                char c = (char)pipedReader.read();
                System.out.print(c);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
