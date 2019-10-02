package SpringCore.SpringPub2Sub;

import org.springframework.context.ApplicationListener;

public class UserEventsProcessor implements ApplicationListener<EmployeeEvent> {
    @Override
    public void onApplicationEvent(EmployeeEvent employeeEvent) {


        System.out.println("Employee " + employeeEvent.getEventType()
                + " with details : " + employeeEvent.getEmployee());
    }
}
