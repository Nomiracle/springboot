package caching;

import javax.validation.constraints.NotNull;

public class Student {
    private @NotNull String id;
    private @NotNull String name;
    private @NotNull String clz;
    public Student(String id,String name ,String clz){
        this.id=id;
        this.name=name;
        this.clz=clz;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClz() {
        return clz;
    }

    public void setClz(String clz) {
        this.clz = clz;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", clz='" + clz + '\'' +
                '}';
    }
}
