package IOExample;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class AppendFile {
    final  String filePath = "D:\\work\\myproject\\springBoot\\HelloWorldApp\\Java\\src\\main\\resources\\IOExample\\IO\\StandardIO\\data.txt";
    void usingBufferedWriter() throws IOException {
        String str = "IOExample.AppendFile.usingBufferedWritter";
        BufferedWriter bf = new BufferedWriter(
                new FileWriter(filePath,true)
        );
        bf.newLine();
        bf.append(str);
        bf.close();
    }
    void usingPrintWriter() throws IOException {
        String str = "IOExample.AppendFile.usingPrintWriter";
        PrintWriter printWriter = new PrintWriter(
                new FileWriter(filePath,true)
        );
        printWriter.println(str);
        printWriter.close();
    }
    void usingFileOutputStream() throws IOException {
        String str = "IOExample.AppendFile.usingFileOutputStream";
        FileOutputStream fileOutputStream
                = new FileOutputStream(filePath,true);
        fileOutputStream.write(str.getBytes());
        fileOutputStream.close();
    }
    void usingPath() throws IOException {
        String str = "IOExample.AppendFile.usingPath";
        Path path = Paths.get(filePath);
        Files.write(
                path,str.getBytes(), StandardOpenOption.APPEND
        );
    }
    public static void main(String[] args) throws IOException {
        AppendFile appendFile = new AppendFile();
        appendFile.usingBufferedWriter();
        appendFile.usingPrintWriter();
        appendFile.usingFileOutputStream();
        appendFile.usingPath();
    }

}
