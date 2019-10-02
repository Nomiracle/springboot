package SpringCore.BeanPostProcessorExample;

public interface EmployeeDAO {
     void initBean();
     void destroyBean();
     EmployeeDTO createNewEmployee();
}
