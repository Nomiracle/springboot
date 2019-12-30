package serialization;

import serialization.model.User;

import java.io.*;
import java.util.Date;

public class CustomSerialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String testData = "testData";
        int testNum = 1;
        Date testDate = new Date();
        User testUser = new User(testData,testData,testNum,testDate);
        testUser.setUserVar(testData);
        System.out.println("testUser object init completed! ");
        String name = "User.ser";
        FileOutputStream fileOut = new FileOutputStream(name);
        ObjectOutputStream objectOutputStream
                = new ObjectOutputStream(fileOut);
        objectOutputStream.writeObject(testUser);
        fileOut.close();
        System.out.println("testUser serializable completed! ");

        FileInputStream fileIn = new FileInputStream(name);
        ObjectInputStream objectInputStream
                = new ObjectInputStream(fileIn);
        User deserializableUser = (User)objectInputStream.readObject();
        fileIn.close();
        System.out.println(deserializableUser);

    }
}
