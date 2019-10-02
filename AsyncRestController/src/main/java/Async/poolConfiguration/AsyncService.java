package Async.poolConfiguration;

import Async.RestApi.EmployeeListVO;
import Async.RestApi.EmployeeReport;
import Async.RestApi.EmployeeVO;
import com.sun.xml.internal.ws.util.CompletedFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class AsyncService {
    private static Logger log = LoggerFactory.getLogger(AsyncService.class);
    @Autowired
    private RestTemplate restTemplate;
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    @Async("asyncExecutor")
    public CompletableFuture<EmployeeVO> getEmployee(int id)
            throws InterruptedException{
        log.info("getEmployee starts");
        EmployeeVO employee =
                restTemplate.getForObject(
                     "http://localhost:8080/employees/"+id
                        ,EmployeeVO.class);
        log.info("employeeData:{}",employee);
        Thread.sleep(1000L);
        log.info("employeeData complete");
        return CompletableFuture.completedFuture(employee);
    }
    @Async("asyncExecutor")
    public CompletableFuture<EmployeeListVO>getEmployeeList()
            throws InterruptedException{
        log.info("getEmployeeList starts");
        EmployeeListVO employees =
                restTemplate.getForObject(
                        "http://localhost:8080/employees/"
                        ,EmployeeListVO.class);
        log.info("EmployeeListData:{}",employees);
        Thread.sleep(1000L);
        log.info("EmployeeListData complete");
        return CompletableFuture.completedFuture(employees);
    }
    @Async("asyncExecutor")
    public CompletableFuture<EmployeeReport>getEmployeeReport(int id)
            throws InterruptedException{
        log.info("getEmployeeReport starts");
        EmployeeReport employeeReport =
                restTemplate.getForObject(
                        "http://localhost:8080/employees/" +id+"/report"
                        ,EmployeeReport.class);
        log.info("EmployeeReportData:{}",employeeReport);
        Thread.sleep(1000L);
        log.info("getEmployeeReportData complete");
        return CompletableFuture.completedFuture(employeeReport);
    }

}
