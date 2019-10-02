package Async.RestApi;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name="employee-report")
public class EmployeeReport implements Serializable {
    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "EmployeeReport{" +
                "num=" + num +
                '}';
    }
}
