package IOExample.IO;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class UTF8EncodedData {
    static void writeUtf8Data(String filename){
        File file = new File(filename);
        try (Writer out = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(file), StandardCharsets.UTF_8
                ))) {
            out.append("Howtodoinjava.com").append("\r\n");
            out.append("UTF-8 Demo").append("\r\n");
            out.append("क्षेत्रफल = लंबाई * चौड़ाई").append("\r\n");
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static void readUtf8Data(String filename){
        File file = new File(filename);
        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(file), StandardCharsets.UTF_8
                ))) {
            String line;
            while((line = bufferedReader.readLine())!=null){
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String name = "/UTF8EncodedData.txt";
        if(UTF8EncodedData.class.getResource(name)==null){
            UTF8EncodedData.writeUtf8Data(
                    "."+name
            );
        }
        UTF8EncodedData.readUtf8Data("."+name);
    }
}
