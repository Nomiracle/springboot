package CustomHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@RestController
@RequestMapping(path="/employees")
public class EmployeeRestCotroller {

    private EmployeeDB employeeDB;
    @Autowired
    EmployeeRestCotroller(EmployeeDB employeeDB){
        this.employeeDB = employeeDB;
    }
    @PostMapping(path="/")
    public ResponseEntity<EmployeeVO>addEmployee(
            @Valid
            @RequestBody
            EmployeeVO employee){
        employeeDB.addEmployee(employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<EmployeeVO>getEmployeeById(@PathVariable("id") int id) throws RecordNotFoundException {
        EmployeeVO employee = employeeDB.getEmployeeById(id);
        if(employee == null)
            throw new RecordNotFoundException("Invalid employee id "+id);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

}
