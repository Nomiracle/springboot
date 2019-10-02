package Async;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeRESTController {
    @RequestMapping(value = "/employees")
    public ResponseEntity<EmployeeListVO> getAllEmployees()throws CloneNotSupportedException{
        EmployeeListVO employeeList=(EmployeeListVO)EmployeeDB.getEmployeeList().clone();

        for (EmployeeVO employee : employeeList.getEmployees()){
            Link link = ControllerLinkBuilder
                          .linkTo(EmployeeRESTController.class)
                          .slash(employee.getEmployeeId())
                          .withSelfRel();

            ResponseEntity<EmployeeReport>methodLinkBuilder
                    =ControllerLinkBuilder
                    .methodOn(EmployeeRESTController.class)
                    .getReportByEmployeeById(employee.getEmployeeId());

            Link reportLink = ControllerLinkBuilder
                    .linkTo(methodLinkBuilder)
                    .withRel("employee-report");

            employee.add(link);
            employee.add(reportLink);
        }
        Link selfLink = ControllerLinkBuilder
                .linkTo(ControllerLinkBuilder
                .methodOn(EmployeeRESTController.class).getAllEmployees())
                .withSelfRel();
        employeeList.add(selfLink);
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
