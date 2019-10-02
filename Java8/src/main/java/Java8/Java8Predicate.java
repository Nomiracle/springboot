package Java8;

import extend.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class Java8Predicate {

    public static void main(String[] args) {
        List<Employee2> employees = Arrays.asList(new Employee2(1,35,"e1"),
                                                 new Employee2(2,25,"e2"),
                                                 new Employee2(1,35,"e3"));
        System.out.println(EmployeePredicates.filterEmployees
                (employees, EmployeePredicates.isAgeMoreThan(20)));
    }
}

class EmployeePredicates{
    public static Predicate<Employee2> isAgeMoreThan(int age){
        return p->p.getAge()>age;
    }
    public static List<Employee2> filterEmployees(List<Employee2> employees,
                                                       Predicate<Employee2>predicate){
        return employees.stream()
                .filter(predicate)
                  .collect(Collectors.toList());
    }
}
class Employee2 extends Employee {
    Employee2(int id,int age,String name){
        super(id,age,name);
    }
    @Override
    public String toString(){
        return new StringJoiner(",","[","]")
                .add(super.getId()+"")
                .add(super.getAge()+"")
                .add(super.getName()).toString();
    }
}
