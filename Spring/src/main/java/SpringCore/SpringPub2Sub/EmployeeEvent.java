package SpringCore.SpringPub2Sub;


import SpringCore.SpringPub2Sub.otherClass.EmployeeDTO;
import org.springframework.context.ApplicationEvent;

public class EmployeeEvent extends ApplicationEvent {
    private String eventType;
    private EmployeeDTO employee;
    public EmployeeEvent(Object source,String eventType, EmployeeDTO employee ) {
        super(source);
        this.employee=employee;
        this.eventType=eventType;
    }



    public String getEventType() {
        return eventType;
    }

    public EmployeeDTO getEmployee() {
        return employee;
    }
}
