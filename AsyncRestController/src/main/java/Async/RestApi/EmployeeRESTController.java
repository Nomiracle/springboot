package Async.RestApi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeRESTController {
    @RequestMapping(value = "/")
    public ResponseEntity<EmployeeListVO> getAllEmployees()throws CloneNotSupportedException{
        EmployeeListVO employeeList=(EmployeeListVO)EmployeeDB.getEmployeeList().clone();

        return new ResponseEntity<>(employeeList,HttpStatus.OK);
    }
    @RequestMapping(value = "/{id}")
    public ResponseEntity<EmployeeVO> getEmployeeById (@PathVariable("id") int id)
    {
        if (id <= 3) {
            EmployeeVO employee =
                    EmployeeDB.getEmployeeList().getEmployees().get(id-1);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @RequestMapping(value = "/{id}/report")
    public ResponseEntity<EmployeeReport>
        getReportByEmployeeById (@PathVariable("id") int id)
    {
        EmployeeReport report = new EmployeeReport();
        report.setNum(id);
        //Do some operation and return report
        return new ResponseEntity<>(report,HttpStatus.OK);
    }


}
