package crud.howtodo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    EmployeeController(EmployeeService service){
        this.service = service;
    }
    private EmployeeService service;

    @GetMapping
    public ResponseEntity<List<EmployeeEntity>>getAllEmployees(){
        List<EmployeeEntity> list = service.getAllEmployees();
        ResponseEntity<List<EmployeeEntity>> g=new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
        return g;

    }
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeEntity>
                getEmployeeById(@PathVariable("id") int id) throws Exception{
        EmployeeEntity entity=service.getEmployeeById(id);

        return new ResponseEntity<>(entity,new HttpHeaders(),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<EmployeeEntity>
        createOrUpdateEmployee(EmployeeEntity entity){
        EmployeeEntity updated = service.createOrUpdateEmployee(entity);
        return new ResponseEntity<>(updated,new HttpHeaders(),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public HttpStatus deleteEmployeeById(@PathVariable("id")int id)
    throws Exception{
        service.deleteEmployeeById(id);
        return HttpStatus.FORBIDDEN;
    }
}
