package security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController
{
    @GetMapping(path="/{id}", produces = "application/json")
    public Employee getEmployees(@PathVariable("id")int id)
    {
        return new Employee("ddd",id);
    }
}

