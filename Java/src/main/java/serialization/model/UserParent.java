package serialization.model;

import java.util.Date;

public class UserParent {
    private String firstName;
    private String lastName;
    private int accountNumber;
    protected Date dateOpened;
    public UserParent(){
        System.out.println("UserParent default constructor called!");
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setDateOpened(Date dateOpened) {
        this.dateOpened = dateOpened;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public Date getDateOpened() {
        return dateOpened;
    }

    @Override
    public String toString() {
        return "UserParent{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", accountNumber=" + accountNumber +
                ", dateOpened=" + dateOpened +
                '}';
    }
}
