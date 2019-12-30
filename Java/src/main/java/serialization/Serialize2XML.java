package serialization;

import serialization.model.UserSettings;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Serialize2XML {
    private static void serializeToXml(UserSettings settings,
                                       String name) throws IOException {
        FileOutputStream fileOutputStream
                = new FileOutputStream(name);
        XMLEncoder encoder = new XMLEncoder(fileOutputStream);
        encoder.setExceptionListener(
                e -> System.out.println("Exception! :"+e.toString())
        );
        encoder.writeObject(settings);
        encoder.close();
        fileOutputStream.close();
    }
    private static UserSettings deSerializeFromXml(String name) throws IOException {
        FileInputStream fileInputStream =
                new FileInputStream(name);
        XMLDecoder decoder =new XMLDecoder(fileInputStream);
        UserSettings decodeSettings = (UserSettings)
                decoder.readObject();
        decoder.close();
        fileInputStream.close();
        return  decodeSettings;
    }

    public static void main(String[] args) throws IOException {
        UserSettings settings = new UserSettings();
        settings.setFieldOne(10000);
        settings.setFieldTwo("HowToDoInJava.com");
        settings.setFieldThree(false);
        String name = "settings.xml";
        //Before
        System.out.println(settings);
        serializeToXml ( settings , name);
        UserSettings loadedSettings = deSerializeFromXml(name);
        //After
        System.out.println(loadedSettings);
    }
}
