package CustomHandler;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="error")
public class ErrResponse {
    //General error message about nature of error
    private String message;

    //Specific errors in API request processing
    private List<String> details;
    ErrResponse(String message, List<String>details){
        super();
        this.message = message;
        this.details=details;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getDetails() {
        return details;
    }

    public void setDetails(List<String> details) {
        this.details = details;
    }
}
