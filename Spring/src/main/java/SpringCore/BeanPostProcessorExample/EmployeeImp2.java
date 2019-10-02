package SpringCore.BeanPostProcessorExample;

public class EmployeeImp2 implements EmployeeDAO{
    public void initBean() {
        System.out.println("initBean for : Employee2DAOImp");
    }

    public void destroyBean() {
        System.out.println("destroyBean for : Employee2DAOImp");
    }

    public EmployeeDTO createNewEmployee() {
        EmployeeDTO e=new EmployeeDTO();
        e.setId(2);
        e.setFirstName("hahah");
        e.setLastName("lalala");
        return e;
    }
}
