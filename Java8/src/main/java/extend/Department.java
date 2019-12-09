package extend;

import java.io.Serializable;

public class Department implements Serializable {
    private int index;
    private String name;
    public Department(int index,String name){
        this.name = name;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "index=" + index +
                ", name='" + name + '\'' +
                '}';
    }
}
