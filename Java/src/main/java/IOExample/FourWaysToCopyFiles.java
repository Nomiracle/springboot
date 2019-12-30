package IOExample;

import IOExample.IO.LineNumberFileReader;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FourWaysToCopyFiles {
    //1) Copy file using apache commons IO
    static void fileCopyUsingApacheCommons(String name) throws IOException {
        File file = new File(
                name
        );
        File newFile = new File(name + "1");
        File newFile2 = new File(name + "2");
        FileUtils.copyFile(file, newFile);
        IOUtils.copy(
                new FileInputStream(file), new FileOutputStream(newFile2)
        );
    }

    //2) Copy file using java.nio.file.Files.copy()
    static void fileCopyUsingNIOFilesClass(String name) throws IOException {
        name =name.substring(1);
        Path source = Paths.get(name);
        Path destination = Paths.get(name + "3");
        Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
    }

    //3) Copy file using java.nio.channels.FileChannel.transferTo()
    static void fileCopyUsingNIOChannelClass(String name) throws IOException {
        File file = new File(name);
        FileInputStream inputStream
                = new FileInputStream(file);
        FileChannel inChannel = inputStream.getChannel();

        FileOutputStream destFile = new FileOutputStream(
                new File(name+"4"));
        FileChannel outChannel = destFile.getChannel();
        inChannel.transferTo(0,file.length(),outChannel);
        inChannel.close();
        outChannel.close();
    }
    //4) Copy file using FileStreams
    static void fileCopyUsingFileStreams(String name) throws IOException {
        File file = new File(name);
        FileInputStream inputStream = new FileInputStream(file);
        File destFile = new File(name+"5");
        FileOutputStream outputStream = new FileOutputStream(destFile);
        byte[] buf = new byte[1024];
        int byteRead;
        while((byteRead = inputStream.read(buf))>0){
            outputStream.write(buf,0,byteRead);
        }
        inputStream.close();
        outputStream.close();
    }

    public static void main(String[] args) throws IOException {
        String name = FourWaysToCopyFiles.class.getResource("copyfile.txt").getPath();
        System.out.println("filePath:"+name);
        FourWaysToCopyFiles.fileCopyUsingApacheCommons(name);
        FourWaysToCopyFiles.fileCopyUsingFileStreams(name);
        FourWaysToCopyFiles.fileCopyUsingNIOChannelClass(name);
        FourWaysToCopyFiles.fileCopyUsingNIOFilesClass(name);
        for (int i=1;i<6;i++){
            System.out.println(name+""+i+":");
            LineNumberFileReader.readFromFile(name+""+i);
        }


    }
}

