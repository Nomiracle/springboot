package IOExample.IO;

import java.io.*;

public class LineNumberFileReader {
    public static void main(String[] args){
        String filePath = LineNumberFileReader.class.getResource("StandardIO/data.txt").getPath();
        System.out.println("filePath:"+filePath);
        LineNumberFileReader.readFromFile(filePath);
        LineNumberFileReader.writeFile(filePath);
        LineNumberFileReader.readFromFile(filePath);

    }
    //Using LineNumberReader with try-with-resources
    public static void readFromFile(String filePath) {
        try (LineNumberReader lineNumberReader = new LineNumberReader(
                new FileReader(filePath)
        )) {
            System.out.println("Line " + lineNumberReader.getLineNumber());
            lineNumberReader.setLineNumber(2);
            System.out.println("Line " + lineNumberReader.getLineNumber());
            String line;
            while ((line = lineNumberReader.readLine()) != null) {
                System.out.println("Line " + line);
            }

        } catch (IOException e) {
            e.getMessage();
        }
    }
    //Using BufferedWriter with try-with-resources
    private static void writeFile(String filePath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(filePath)
        )) {
            String content = "Hello Learner !! Welcome to howtodoinjava.com.";
            bufferedWriter.write(content);
        } catch (IOException e) {
            e.getMessage();
        }
    }
}

