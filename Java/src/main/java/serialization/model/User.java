package serialization.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public class User extends UserParent implements Serializable {
    private static final long serialVersionUID = 7829136421241571165L;
    private String userVar;
    public User(){
        System.out.println("User default constructor called!");
    }

    public User(String firstName, String lastName, int accountNumber, Date dateOpened) {
        super.setFirstName(firstName);
        super.setLastName(lastName);
        super.setAccountNumber(accountNumber);
        super.setDateOpened(dateOpened);
    }
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeUTF(super.getFirstName());
        objectOutputStream.writeUTF(super.getLastName());
        objectOutputStream.writeInt(super.getAccountNumber());
        objectOutputStream.writeLong(dateOpened.getTime());
        objectOutputStream.writeUTF(userVar);
    }
    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        super.setFirstName(objectInputStream.readUTF());
        super.setLastName(objectInputStream.readUTF());
        super.setAccountNumber(objectInputStream.readInt());
        dateOpened = new Date(objectInputStream.readLong());
        userVar = objectInputStream.readUTF();
    }
    public void setUserVar(String userVar) {
        this.userVar = userVar;
    }

    @Override
    public String toString() {
        return "User{" + super.toString()+
                "userVar='" + userVar + '\'' +
                '}';
    }
}
