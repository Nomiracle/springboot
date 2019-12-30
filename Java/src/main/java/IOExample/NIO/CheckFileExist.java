package IOExample.NIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CheckFileExist {
    public static void main(String[] args) {
        final Path path;
        try
        {
            path = Files.createTempFile("myTempFile", ".txt");
            boolean exists = Files.exists(path);
            System.out.println("Temp file exists : " + exists);
            System.out.println("Temp file is Readable : " + Files.isReadable(path));
            System.out.println("Temp file is Writable : " + Files.isWritable(path));
            System.out.println("Temp file is Executable : " + Files.isExecutable(path));
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
