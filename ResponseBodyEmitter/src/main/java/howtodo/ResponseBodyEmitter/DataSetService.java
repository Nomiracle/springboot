package howtodo.ResponseBodyEmitter;

import howtodo.model.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import howtodo.service.EmployeeService;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class DataSetService {
    private final EmployeeService employeeService;

    @Autowired
    public DataSetService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/fetch-data-sets")
    public ResponseBodyEmitter fetchData(){
        ResponseBodyEmitter emitter
                = new ResponseBodyEmitter();
        ExecutorService executorService
                = Executors.newSingleThreadExecutor();
        executorService.execute(()->{
            List<EmployeeEntity> entityList
                    = employeeService.getAllEmployees();

            entityList.forEach(a -> {
                try {
                    randomDelay();
                    emitter.send(a);
                } catch (IOException e) {
                    emitter.completeWithError(e);
                }
            });
            emitter.complete();
        });
        executorService.shutdown();
        return emitter;
    }
    private void randomDelay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
