package serialization;

import serialization.model.UserSettings;

import java.io.*;

public class JavaDeepCopyExample
        extends UserSettings  {
    JavaDeepCopyExample deepCopy() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bos
                = new ByteArrayOutputStream();
        ObjectOutputStream outputStream
                = new ObjectOutputStream(bos);
        outputStream.writeObject(this);
        System.out.println(this);

        ByteArrayInputStream bis = new ByteArrayInputStream(
                bos.toByteArray()
        );
        ObjectInputStream in = new ObjectInputStream(bis);

        return (JavaDeepCopyExample)
                in.readObject();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException{
        JavaDeepCopyExample settings = new JavaDeepCopyExample();
        settings.setFieldOne(10000);
        settings.setFieldTwo("HowToDoInJava.com");
        settings.setFieldThree(true);
        //After
        UserSettings copied = settings.deepCopy();
        System.out.println(copied);
    }
    @Override
    public String toString() {
        return "UserSettings [fieldOne=" + super.getFieldOne()
                + ", fieldTwo=" + super.getFieldTwo()
                + ", fieldThree=" + !super.getFieldThree() + "]";
    }


}
