package SpringCore.SpringBeanAutowiring.byName;

import SpringCore.SpringBeanAutowiring.DepartmentBean;

public class EmployeeBean {
    private String fullName;


    private DepartmentBean hahaha;

    public DepartmentBean getDepartmentBean() {
        return hahaha;
    }

    public void setHahaha(DepartmentBean departmentBean) {
        this.hahaha = departmentBean;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
