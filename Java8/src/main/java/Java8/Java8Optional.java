package Java8;

import java.util.Optional;

public class Java8Optional {
    public static void main(String[] args) {
        Optional<Company>optionalCompany
                = Optional.empty();

        Company company = optionalCompany.orElse(new Company("c3",10));
        System.out.println(company);

        Optional<Company>optionalCompany1
                = Optional.of(new Company("c1",12));


        optionalCompany1.filter(cpy->"c1".equals(cpy.getName())).ifPresent(System.out::println);
        Company company2 = optionalCompany1.orElse(new Company("c2",1));
        System.out.println(company2);



        Company company3 = optionalCompany1.orElseThrow(IllegalStateException::new);
        Company company1 = optionalCompany.orElseThrow(IllegalStateException::new);




    }
}

class Company{
    private String name;
    private int age;
    Company(String name
             ,int age){
        this.age = age;
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return name+","+age;
    }
}