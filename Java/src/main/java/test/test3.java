package test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class test3 {
    public static void main(String[] args) throws IOException {

        List<String>fileNames = Arrays.asList("50000-50270","53529-90308","51774-57422","16860-50000","50271-51773","90309-99999");
        StringJoiner arraySymbol = new StringJoiner(",", "[", "]");

        Map<Integer,String> temMap = new TreeMap<>();

        for(String fileName : fileNames){
            System.out.println(fileName);
            File file = new File("C:\\Users\\30819\\Desktop\\"+fileName+".txt");
            try (BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(file), StandardCharsets.UTF_8
                    ))) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    try {
                        temMap.put(Integer.parseInt(line.split(",")[0]),line.split(",")[1]);
                    }catch (Exception e){
                        System.out.println(line);
                    }

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        File file = new File("C:\\Users\\30819\\Desktop\\1-18370.txt");
        System.out.println("C:\\Users\\30819\\Desktop\\1-18370.txt");
        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(file), StandardCharsets.UTF_8
                ))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                try {
                    temMap.put(Integer.parseInt(line.split(",")[1]),line.split(",")[2]);
                }catch (Exception e){
                    System.out.println(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        StringBuilder content = new StringBuilder();
        temMap.keySet().forEach((k)->{
            content.append(k).append(",").append(temMap.get(k)).append("\r\n");
        });
        usingFileChannel(content.toString());
        System.out.println(content.toString() +",total:"+temMap.size());

    }

    static void usingFileChannel(String str) throws IOException {
        String fileName = "generated";
        String filePath = "C:\\Users\\30819\\Desktop\\"+fileName+".txt";

        BufferedWriter bufferedWriter
                = new BufferedWriter(new FileWriter(filePath));
        bufferedWriter.write(str);
        bufferedWriter.close();
    }
}
