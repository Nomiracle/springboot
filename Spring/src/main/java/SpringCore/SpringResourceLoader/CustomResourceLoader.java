package SpringCore.SpringResourceLoader;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class CustomResourceLoader implements ResourceLoaderAware {

    private ResourceLoader resourceLoader;
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
    public void showResourceData() throws IOException {
        Resource banner
                =resourceLoader.getResource(
                 //"file:C:\\Users\\30819\\Desktop\\注册清单.txt"           //file system
                "file:src/main/resources/SpringCore.SpringResourceLoader/data.txt" //root folder
                //"classpath:SpringCore.SpringResourceLoader/classpath.txt"          //classpath
                //"//howtodoinjava.com/readme.txt"                         //url
        );
        InputStream in = banner.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
        while(true){
            String line = reader.readLine();
            if(line == null)break;
            System.out.println(line);
        }
        System.out.println("------------------------------------------------------------------");
        reader.close();
    }
}
