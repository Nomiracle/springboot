package RetryModule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
    @Autowired
    BackendAdapter backendAdapter;

    @GetMapping("/retry")
    @ExceptionHandler({Exception.class})
    public String validateSpringRetryCapability(@RequestParam(required = false)
                                                boolean simulateRetry,
                                                @RequestParam(required = false)
                                                boolean simulateRetryFallback)
            throws RemoteServiceNotAvailableException {
        System.out.println("=====================================");
        System.out.println("Inside RestController method ...");
        return backendAdapter.getBackendResponse(simulateRetry,simulateRetryFallback);
    }
}
