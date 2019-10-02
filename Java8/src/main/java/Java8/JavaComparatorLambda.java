package Java8;

import extend.Employee;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JavaComparatorLambda {
    public static void main(String[] args) {
        Comparator<Employee1>comparebyid1 = Comparator.comparing(e->e.getId());
        Comparator<Employee1>comparebyAge
                = (Employee1 e1,Employee1 e2)->(e1.getAge()).compareTo(e2.getAge());
        Comparator<Employee1>comparebyFirstName=Comparator.comparing(e->e.getFirstName());
        List<Employee1>employees = Arrays.asList(new Employee1(5,10,"e1","tom2")
                ,new Employee1(2,16,"e6","tom3")
                ,new Employee1(3,6,"e3","tom1")
                ,new Employee1(4,3,"e3","tom2")
                ,new Employee1(4,3,"e4","tom3"));
//        Collections.sort(employees,comparebyid1);
//        employees.stream().forEach(System.out::println);
//        Collections.sort(employees,comparebyAge);
//        employees.stream().forEach(System.out::println);
//        Collections.sort(employees,comparebyFirstName);
//        employees.stream().forEach(System.out::println);
//        Comparator<Employee>comparebyAgeandId
//                =Comparator.comparing(Employee::getAge).thenComparing(Employee::getId);
//        Collections.sort(employees,comparebyAgeandId);
//        employees.stream().forEach(System.out::println);
//        Employee[] employeesArray = employees.toArray(new Employee[employees.size()]);
//        Arrays.parallelSort(employeesArray,comparebyid1);
//        Arrays.stream(employeesArray).forEach(System.out::println);
        employees.parallelStream().sorted(comparebyid1.thenComparing(Employee1::getAge));
        employees.stream().forEach(System.out::println);

    }
}
class Employee1 extends Employee {
    Employee1(int id,int age,String firstName, String lastName){
        super(id, age,firstName, lastName);
    }
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + super.getId() +
                ", age=" + super.getAge() +
                ", firstName='" + super.getFirstName() + '\'' +
                ", lastName='" + super.getLastName() + '\'' +
                '}';
    }

}
