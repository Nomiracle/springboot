package IOExample;

import com.google.common.base.Charsets;
import com.google.common.io.ByteSource;
import com.google.common.io.CharStreams;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class InputStream2String {
    //1.1 InputStream to String using Google Guava IO
    static void usingGuava(InputStream inputStream){
        ByteSource byteSource
                = new ByteSource() {
            @Override
            public InputStream openStream() {
                return inputStream;
            }
        };
        String text = null;
        try {
            text = byteSource.asCharSource(Charsets.UTF_8).read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(text);
    }
    //1.2.InputStream to String with CharStreams class in Google guava library.
    static void usingCharStreams(InputStream inputStream){
        String text = null;

        try (final Reader reader = new InputStreamReader(inputStream)) {
            text = CharStreams.toString(reader);
        }catch (IOException e){
            e.printStackTrace();
        }

        System.out.println(text);
    }
    //2. Convert InputStream to String with BufferedReader
    static void usingBufferedReader(InputStream inputStream){

        try (BufferedReader bufferedReader= new BufferedReader(
                new InputStreamReader(
                        inputStream
                ))) {
            StringBuilder out = new StringBuilder();
            String line;
            while((line = bufferedReader.readLine())!=null){
                out.append(line);
            }
            System.out.println(out.toString());
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    //3.Apache Commons IOUtils (Most Readable)
    static void ReadStreamIntoStringUsingIOUtils(InputStream inputStream){
        //Method 1 IOUtils.copy()
        StringWriter writer = new StringWriter();
        try {
            IOUtils.copy(
                    inputStream,writer, StandardCharsets.UTF_8.name()
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(writer.toString()+StandardCharsets.UTF_8.name());
    }
    //4. Java InputStream to String using Scanner
    static void ReadStreamIntoStringUsingScanner(InputStream inputStream){
        Scanner scanner = new Scanner(inputStream,StandardCharsets.UTF_8.name())
                .useDelimiter("\\A");
        String str = scanner.hasNext()?scanner.next():"";
        System.out.println(str);
        scanner.close();
    }
    public static void main(String[] args) {
        String data = "123456";
        InputStream2String.usingGuava(
                String2InputStream.usingByteArrayInputStream(data));
        InputStream2String.usingGuava(
                String2InputStream.usingIOUtils(data));
        InputStream2String.usingCharStreams(
                String2InputStream.usingByteArrayInputStream(data));
        InputStream2String.usingCharStreams(
                String2InputStream.usingIOUtils(data));
        InputStream2String.usingBufferedReader(
                String2InputStream.usingIOUtils(data));
        InputStream2String.ReadStreamIntoStringUsingIOUtils(
                String2InputStream.usingIOUtils(data));
        InputStream2String.ReadStreamIntoStringUsingScanner(
                String2InputStream.usingIOUtils(data));
    }

}
