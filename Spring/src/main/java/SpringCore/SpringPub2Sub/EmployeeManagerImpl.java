package SpringCore.SpringPub2Sub;


import SpringCore.SpringPub2Sub.otherClass.EmployeeDAO;
import SpringCore.SpringPub2Sub.otherClass.EmployeeDTO;
import SpringCore.SpringPub2Sub.otherClass.EmployeeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

@Service("employeeManager")
public class EmployeeManagerImpl implements EmployeeManager,ApplicationEventPublisherAware {
    @Autowired
    private EmployeeDAO dao;
    private ApplicationEventPublisher publisher;



    @Override
    public void setApplicationEventPublisher
            (ApplicationEventPublisher applicationEventPublisher) {
        this.publisher=applicationEventPublisher;
    }

    public EmployeeDTO createNewEmployee()
    {
        EmployeeDTO employee =  dao.createNewEmployee();

        //publishing the veent here
        publisher.publishEvent(
                new EmployeeEvent(this, "ADD", employee));

        return employee;
    }
}
