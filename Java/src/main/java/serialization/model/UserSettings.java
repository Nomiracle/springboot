package serialization.model;

import java.io.Serializable;

public class UserSettings implements Serializable {
    public UserSettings(){}

    private Integer fieldOne;
    private String fieldTwo;
    private boolean fieldThree;
//    private Integer fieldOne;
//    private String fieldTwo;
//    private boolean fieldThree;

    public Integer getFieldOne() {
        return fieldOne;
    }

    public void setFieldOne(Integer fieldOne) {
        this.fieldOne = fieldOne;
    }

    public String getFieldTwo() {
        return fieldTwo;
    }

    public void setFieldTwo(String fieldTwo) {
        this.fieldTwo = fieldTwo;
    }

    public boolean getFieldThree() {
        return fieldThree;
    }

    public void setFieldThree(boolean fieldThree) {
        this.fieldThree = fieldThree;
    }

    @Override
    public String toString() {
        return "UserSettings [fieldOne=" + fieldOne + ", fieldTwo=" + fieldTwo
                + ", fieldThree=" + fieldThree + "]";
    }
}
