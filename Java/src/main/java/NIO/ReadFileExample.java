package NIO;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ReadFileExample {
    public static void main(String[] args) throws IOException {
        RandomAccessFile accessFile = new RandomAccessFile(
              "D:\\work\\myproject\\springBoot\\HelloWorldApp\\Java\\src\\main\\resources\\IO\\StandardIO\\data.txt",
                "r"
        );
        FileChannel inChannel = accessFile.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while(inChannel.read(buffer)>0){
            buffer.flip();
            for(int i = 0;i<buffer.limit();i++){
                System.out.print((char) buffer.get());
            }
            buffer.clear();
        }
        inChannel.close();
        accessFile.close();

    }
}
