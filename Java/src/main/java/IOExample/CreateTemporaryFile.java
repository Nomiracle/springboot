package IOExample;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CreateTemporaryFile {
    //Creating temporary file using java.io.File.createTempFile()
    static void usingIOCreateTmpDir() throws IOException {
        System.out.println("Creating temporary file using java.io.File.createTempFile():");

        File tmp = File.createTempFile("mytmp","txt");
        BufferedWriter bf = new BufferedWriter(
                new FileWriter(tmp)
        );
        bf.write("This is the temporary data written to temp file");
        bf.close();
        //Delete on runtime exit,To delete a file when apllication exists or completes
        tmp.deleteOnExit();
        System.out.println("Temp file created : " + tmp.getAbsolutePath());
    }
    //Creating temporary file using NIO
    static void usingNIOCreateTmpDir() throws IOException {
        System.out.println("Creating temporary file using NIO");
        final Path path = Files.createTempFile("mytmp","txt");
        byte[] buf = "some datum.".getBytes();
        Files.write(path,buf);
        System.out.println("Temp file created : " + path);
        Files.deleteIfExists(path);
        //Delete file on exit
        path.toFile().deleteOnExit();
    }

    public static void main(String[] args) throws IOException {
        CreateTemporaryFile.usingIOCreateTmpDir();
        CreateTemporaryFile.usingNIOCreateTmpDir();
    }
}
