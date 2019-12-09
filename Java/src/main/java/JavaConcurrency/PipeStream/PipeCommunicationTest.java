package JavaConcurrency.PipeStream;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class PipeCommunicationTest {
    public static void main(String[] args) throws IOException {
        PipedReader pr = new PipedReader();
        PipedWriter pw = new PipedWriter();

        pw.connect(pr);
        Thread thread1 = new Thread(new PipeReaderThread("reader",pr));
        Thread thread2 = new Thread(new PipeWriterThread(pw,"writer"));
        thread1.start();
        thread2.start();
    }
}
