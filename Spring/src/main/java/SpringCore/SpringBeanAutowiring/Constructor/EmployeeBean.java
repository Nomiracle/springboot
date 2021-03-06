package SpringCore.SpringBeanAutowiring.Constructor;

import SpringCore.SpringBeanAutowiring.DepartmentBean;

public class EmployeeBean {
    private String fullName;


    private DepartmentBean departmentBean;
    EmployeeBean(DepartmentBean departmentBean){
        this.departmentBean = departmentBean;
    }

    public DepartmentBean getDepartmentBean() {
        return departmentBean;
    }

    public void setDepartmentBean(DepartmentBean departmentBean) {
        this.departmentBean = departmentBean;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
