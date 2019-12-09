package Collections.Array;

import Collections.Array.extend.Department;
import Collections.Array.extend.Employee;

public class shadowClone {
    public static void main(String[] args) {
        Employee[] empArr = new Employee[2];    //Original array
        empArr[0] = new Employee(100, "Lokesh",
                "Gupta", new Department(1, "HR"));
        empArr[1] = new Employee(200, "Pankaj",
                "Kumar", new Department(2, "Finance"));
        Employee[] clonedArray = empArr.clone();  //Shallow copied array

        empArr[0].setFirstName("Unknown");
        empArr[0].getDepartment().setName("Unknown");

        //Verify the change in original array - "CHANGED"
        System.out.println(empArr[0].getFirstName());                     //Unknown
        System.out.println(empArr[0].getDepartment().getName());          //Unknown

        //Verify the change in cloned array - "CHANGED"
        System.out.println(clonedArray[0].getFirstName());                  //Unknown
        System.out.println(clonedArray[0].getDepartment().getName());       //Unknown
    }
}
