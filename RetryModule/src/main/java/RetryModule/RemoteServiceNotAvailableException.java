package RetryModule;

public class RemoteServiceNotAvailableException extends Throwable {
    RemoteServiceNotAvailableException(String info){
        super(info);
    }
}
