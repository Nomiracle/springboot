package SpringCore.SpringUtilConstant;

public class EmployeeDTO {
    public static final EmployeeDTO MANAGER
            = new EmployeeDTO("manager");

    public static final EmployeeDTO DIRECTOR
            = new EmployeeDTO("director");

    private Integer id;
    private String firstName;
    private String lastName;
    private String designation;
    private static int i;



    public EmployeeDTO(String designation)
    {
        System.out.println("instantiated "+(i++) +" times!");
        this.id = -1;
        this.firstName = "dummy";
        this.lastName = "dummy";
        this.designation = designation;
    }


    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName
                + ", lastName=" + lastName + ", type=" + designation + "]";
    }

    public static EmployeeDTO getMANAGER() {
        return MANAGER;
    }

    public static EmployeeDTO getDIRECTOR() {
        return DIRECTOR;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
