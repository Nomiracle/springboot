package IOExample;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class WriteToFile {
    final  String filePath = "D:\\work\\myproject\\springBoot\\HelloWorldApp\\Java\\src\\main\\resources\\IOExample\\IO\\StandardIO\\data.txt";
    void usingBufferedWriter() throws IOException {
        String str = "IOExample.WriteToFile.usingBufferedWriter";
        BufferedWriter bufferedWriter
                 = new BufferedWriter(new FileWriter(filePath));
        bufferedWriter.write(str);
        bufferedWriter.close();
    }
    void usingFileWriter() throws IOException {
        String str = "IOExample.WriteToFile.usingFileWriter";
        FileWriter fileWriter = new FileWriter(filePath);
        fileWriter.write(str);
        fileWriter.close();
    }
    void usingPrintWriter() throws IOException {
        String str = "IOExample.WriteToFile.usingPrintWriter";
        FileWriter fileWriter = new FileWriter(filePath);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(str);
        printWriter.printf("Blog name is %s", "howtodoinjava.com");
        printWriter.close();
    }
    void usingFileOutputStream() throws IOException {
        String str = "IOExample.WriteToFile.usingFileOutputStream";
        FileOutputStream outputStream = new FileOutputStream(filePath);
        byte[] strToBytes = str.getBytes();
        outputStream.write(strToBytes);
        outputStream.close();
    }
    void usingDataOutputStream() throws IOException {
        String str = "IOExample.WriteToFile.usingDataOutputStream";
        FileOutputStream outputStream
                = new FileOutputStream(filePath);
        DataOutputStream dataOutputStream
                = new DataOutputStream(new BufferedOutputStream(
                        outputStream
        ));
        dataOutputStream.writeUTF(str);
        dataOutputStream.close();
    }
    void usingFileChannel() throws IOException {
        String str = "IOExample.WriteToFile.usingFileChannel";
        RandomAccessFile stream = new RandomAccessFile(
                filePath,"rw"
        );
        FileChannel fileChannel = stream.getChannel();
        byte[] strBytes = str.getBytes();
        ByteBuffer buffer = ByteBuffer.allocate(strBytes.length);
        buffer.put(strBytes);
        buffer.flip();
        fileChannel.write(buffer);
        stream.close();
        fileChannel.close();
    }
    public static void main(String[] args) throws IOException {
        //1.If we try to write to a file that doesn’t exist, the file will be created first and no exception will be thrown (except using Path method).
        //2.Always close the output stream after writing the file content to release all resources. It will also help in not corrupting the file.
        //3.Use PrintWriter is used to write formatted text.
        //4.Use FileOutputStream to write binary data.
        //5.Use DataOutputStream to write primitive data types.
        //6.Use FileChannel to write larger files.
        WriteToFile wf = new WriteToFile();
        wf.usingBufferedWriter();
        wf.usingFileWriter();
        wf.usingPrintWriter();
        wf.usingFileOutputStream();
        wf.usingDataOutputStream();
        wf.usingFileChannel();
    }
}
