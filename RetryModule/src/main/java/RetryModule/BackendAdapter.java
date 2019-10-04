package RetryModule;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;

public interface  BackendAdapter {
   @Retryable(value={RemoteServiceNotAvailableException.class},maxAttempts = 3,
   backoff = @Backoff(delay = 1000))
   String getBackendResponse(boolean simulateRetry, boolean simulateRetryFallback) throws RemoteServiceNotAvailableException;
   @Recover
   String getBackendResponseFallback(RuntimeException e);



}
