package howtodo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path="/employees")
public class EmployeeController {
    private EmployeeDAO employeeDAO;
    @Autowired
    EmployeeController(EmployeeDAO employeeDAO){
        this.employeeDAO = employeeDAO;
    }

    @GetMapping(path="/")
    public ResponseEntity<Employees> getEmployees(){
        return new ResponseEntity(employeeDAO.getAllEmployees(), HttpStatus.OK);
    }
    @PostMapping(path="/")
    public String addEmployee(
            @RequestHeader(name="X-COM-PERSIST")
            String headpersist,
            @RequestHeader(name="X-COM-PERSIST",required = false,defaultValue = "Asia")
            String headLocation,
            @RequestBody
            Employee employee
    )throws Exception{
        int id = employeeDAO.getAllEmployees().getEmployeeList().size()+1;
        employee.setId(id);
        employeeDAO.addEmployee(employee);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(employee.getId())
                .toUri();
        return ResponseEntity.created(location).build().toString();
    }
}
