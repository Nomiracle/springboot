package serialization;


import serialization.model.UserSettings;

import java.io.*;

public class ExternalizationImp extends UserSettings implements Externalizable {

    private String doNotStoreMe;

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(super.getFieldOne());
        out.writeUTF(super.getFieldTwo());
        out.writeBoolean(super.getFieldThree());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException {
        super.setFieldOne(in.readInt());
        super.setFieldTwo(in.readUTF());
        super.setFieldThree(in.readBoolean());
    }

    public static void main(String[] args) {
        ExternalizationImp settings = new ExternalizationImp();
        settings.setDoNotStoreMe("Sensitive info");
        settings.setFieldOne(10000);
        settings.setFieldTwo("HowToDoInJava.com");
        settings.setFieldThree(false);
        //Before
        System.out.println(settings);
        String name = "object.ser";
        storeUserSetting(settings,name);
//        System.out.println(
//          "filePath:" + UserSettings.class.getResource(name).getPath()
//        );
        ExternalizationImp userSettings = loadSettings(name);
        System.out.println(userSettings);
    }
    private static ExternalizationImp loadSettings(String name){
        try{
            FileInputStream fileInputStream
                    = new FileInputStream(name);
            ObjectInputStream objectInputStream
                    = new ObjectInputStream(fileInputStream);
            ExternalizationImp settings
                    = (ExternalizationImp)objectInputStream.readObject();
            objectInputStream.close();
            return settings;
        }catch (IOException|ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
    private static void storeUserSetting(ExternalizationImp settings,
                                         String name){
        try {
            FileOutputStream fileOutputStream
                    = new FileOutputStream(name);
            ObjectOutputStream objectOutputStream
                    = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(settings);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getDoNotStoreMe() {
        return doNotStoreMe;
    }

    public void setDoNotStoreMe(String doNotStoreMe) {
        this.doNotStoreMe = doNotStoreMe;
    }

    @Override
    public String toString() {
        return "ExternalizationImp{" +super.toString()+
                "doNotStoreMe='" + doNotStoreMe + '\'' +
                '}';
    }
}
