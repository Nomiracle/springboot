package Async.poolConfiguration;

import Async.RestApi.EmployeeListVO;
import Async.RestApi.EmployeeReport;
import Async.RestApi.EmployeeVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
public class AsyncController {
    private static Logger log = LoggerFactory.getLogger(AsyncController.class);
    @Autowired
    private AsyncService service;
    @GetMapping(value="/testAsync/{id}")
    public void testAsync(@PathVariable("id") int id)
            throws InterruptedException, ExecutionException{
        log.info("testAsynch Start");
        CompletableFuture<EmployeeVO> employee =
                 service.getEmployee(id);
        CompletableFuture<EmployeeListVO>employeeList =
                service.getEmployeeList();
        CompletableFuture<EmployeeReport>employeeReport=
                service.getEmployeeReport(id);
        CompletableFuture<Void> combinedFuture
                = CompletableFuture.allOf(employee,employeeList,employeeReport);
        combinedFuture.join();
        log.info("employee--> " + employee.get());
        log.info("employeeList--> " + employeeList.get());
        log.info("employeeReport--> " + employeeReport.get());
        log.info("combinedFuture--> " + combinedFuture.get());
    }
}
