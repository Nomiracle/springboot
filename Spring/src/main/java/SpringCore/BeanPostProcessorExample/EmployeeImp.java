package SpringCore.BeanPostProcessorExample;

public class EmployeeImp implements EmployeeDAO{
    public void initBean() {
        System.out.println("initBean for : EmployeeDAOImp");
    }

    public void destroyBean() {
        System.out.println("destroyBean for : EmployeeDAOImp");
    }

    public EmployeeDTO createNewEmployee() {
        EmployeeDTO e=new EmployeeDTO();
        e.setId(1);
        e.setFirstName("Lokesh");
        e.setLastName("Gupta");
        return e;
    }
}
