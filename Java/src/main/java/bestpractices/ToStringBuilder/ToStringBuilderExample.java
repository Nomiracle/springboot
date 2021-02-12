package bestpractices.ToStringBuilder;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ToStringBuilderExample {
    public static void main(String[] args) {
        //1) toString() method is top most super class used perfectly by all subclasses
        AbstractUser guest1 = getAbstractUser();
        System.out.println(guest1);
        GuestUser guest2 = getGuestUser();
        System.out.println(guest2);
        WebUser2 webUser2 = getWebUser2();
        System.out.println(webUser2);
        GuestUser2 guestUser2 = getGuestUser2();
        System.out.println(guestUser2);
    }
    public static AbstractUser getAbstractUser() {
        AbstractUser user = new AbstractUser();
        user.setId(100);
        user.setFirstName("Lokesh");
        user.setLastName("Gupta");
        user.setAge("30");
        return user;
    }
    public static WebUser2 getWebUser2() {
        WebUser2 user = new WebUser2();
        user.setId(100);
        user.setFirstName("Lokesh");
        user.setLastName("Gupta");
        user.setAge("30");
        user.setLastLoggedIn(new Date());
        return user;
    }

    public static GuestUser getGuestUser() {
        GuestUser user = new GuestUser();
        user.setId(100);
        user.setFirstName("Lokesh");
        user.setLastName("Gupta");
        user.setAge("30");
        user.setLastLoggedIn(new Date());
        user.setLocation("New Delhi");
        return user;
    }
    public static GuestUser2 getGuestUser2(){
        GuestUser2 user = new GuestUser2();
        user.setId(100);
        user.setFirstName("Lokesh");
        user.setLastName("Gupta");
        user.setAge("30");
        user.setLastLoggedIn(new Date());
        user.setLocation("New Delhi");
        return user;
    }
}

class AbstractUser implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String firstName;
    private String lastName;
    private String age;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}

class WebUser extends AbstractUser {
    private static final long serialVersionUID = 1L;
    private Date lastLoggedIn;

    public Date getLastLoggedIn() {
        return lastLoggedIn;
    }

    public void setLastLoggedIn(Date lastLoggedIn) {
        this.lastLoggedIn = lastLoggedIn;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this,
                new CustomToStringStyle());
    }
}
//3) Use information from super class in sub class with easy method call
class WebUser2 extends AbstractUser {
    private static final long serialVersionUID = 1L;
    private Date lastLoggedIn;

    public Date getLastLoggedIn() {
        return lastLoggedIn;
    }

    public void setLastLoggedIn(Date lastLoggedIn) {
        this.lastLoggedIn = lastLoggedIn;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("lastLoggedIn",lastLoggedIn).toString();
    }
}

class GuestUser extends WebUser {
    private static final long serialVersionUID = 1L;
    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
class GuestUser2 extends WebUser {
    private static final long serialVersionUID = 1L;
    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(
                this,new CustomToStringStyle(),true,GuestUser2.class
        );
    }
}

//2) Custom formatting of any field type like Date
class CustomToStringStyle extends ToStringStyle{
    private static final long serialVersionUID = 1L;
    @Override
    protected void appendDetail(StringBuffer buffer, String fieldName, Object value) {
        if(value instanceof Date){
            value = new SimpleDateFormat("yyyy-MM-dd")
                    .format(value);
        }
        buffer.append(value);
    }
}