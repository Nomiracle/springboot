package IOExample.IO;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;


public class PropertyFileOperation {
    private final Properties properties
            = new Properties();
    private PropertyFileOperation(){
//        String fileName = "configFile.config";//==>unusable
//        String fileName = "/configFile.config";//==>unusable
//        String fileName ="/classes/IOExample/IO/configfile/configFile.config";//==>unusable
//        String fileName ="/IOExample/IO/configfile/configFile.config"; //==>usable
//        String fileName ="/IO/configfile/configFile.config";//==>unusable
//        String fileName ="/configfile/configFile.config";//==>unusable
        String fileName ="configfile/configFile.config";//==>usable
        InputStream in = PropertyFileOperation.class.getResourceAsStream(fileName);
//        System.out.println(
//                PropertyFileOperation.class.getResource(
//                        ""+fileName
//                ).getPath()
//        );
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Bill Pugh Solution for singleton pattern
    private static class LazyHolder{
        private static final PropertyFileOperation INSTANT
                = new PropertyFileOperation();
    }
    public static PropertyFileOperation getInstance(){
        return LazyHolder.INSTANT;
    }
    public String getProperty(String key){
        return properties.getProperty(key);
    }
    public Set<String>getAllPropertyNames(){
        return properties.stringPropertyNames();
    }
    public  boolean containsKey(String key){
        return properties.containsKey(key);
    }
    public void setProperties(String key,String value){
        properties.setProperty(key,value);
    }

    public static void main(String[] args) {
        PropertyFileOperation propertyFileOperation
                = PropertyFileOperation.getInstance();
        System.out.println(
                propertyFileOperation.getAllPropertyNames()
        );
        System.out.println(
                propertyFileOperation.getProperty("firstName")
        );
        System.out.println(
                propertyFileOperation.containsKey("firstName")
        );
        String key = "country",value = "sahnghai";

        if (!propertyFileOperation.containsKey(key)){
            propertyFileOperation.setProperties(key,value);
        }
        //Verify property
        System.out.println(propertyFileOperation.getProperty(key));
    }
}
