package IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StandardIO {
    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        String sCurrentLine = null;
        try{
            bufferedReader = new BufferedReader(
              new FileReader("D:\\work\\myproject\\springBoot\\" +
                      "HelloWorldApp\\Java\\src\\main\\resources\\IO\\" +
                      "StandardIO\\data.txt")
            );
            while((sCurrentLine = bufferedReader.readLine())!=null){
                System.out.println(sCurrentLine);
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            try{
                if(bufferedReader!=null){
                    bufferedReader.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
