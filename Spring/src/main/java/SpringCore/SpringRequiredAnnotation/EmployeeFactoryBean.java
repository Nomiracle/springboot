package SpringCore.SpringRequiredAnnotation;

import org.springframework.beans.factory.annotation.Required;

public class EmployeeFactoryBean  {


    private String designation;

    public String getDesignation() {
        return designation;
    }
    @Required
    public void setDesignation(String designation) {
        this.designation = designation;
    }

}
