package Java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Java8FileList{
    public static void main(String[] args)

    {
//        try{
//        Files.list(Paths.get("."))
//                .filter(Files::isDirectory)
//                .forEach(System.out::println);
//        }
//        catch (IOException i){
//            i.getStackTrace();
//        }
        //        try{
//        Files.list(Paths.get("."))
//                .filter(Files::isDirectory)
//                .forEach(System.out::println);
//        }
//        catch (IOException i){
//            i.getStackTrace();
//        }
        try{
            Files.newDirectoryStream(Paths.get("."))
                    .forEach(System.out::println);
        }
        catch (IOException i){
            i.getStackTrace();
        }

    }
}
