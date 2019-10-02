package CustomHandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked","rawtypes"})
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    final ResponseEntity<Object>
    handleAllException(Exception exception, WebRequest request){
        List<String> details = new ArrayList<>();
        details.add(exception.getLocalizedMessage());
        ErrResponse errResponse = new ErrResponse("server error",details);
        return new ResponseEntity(errResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(RecordNotFoundException.class)
    final ResponseEntity<Object>handleUserNotFoundException
            (Exception exception, WebRequest request){
        List<String> details = new ArrayList<>();
        details.add(exception.getLocalizedMessage());
        ErrResponse errResponse = new ErrResponse("Record Not Found",details);
        return new ResponseEntity(errResponse, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid
            (MethodArgumentNotValidException ex, HttpHeaders headers,
             HttpStatus status, WebRequest request) {
        List<String>details= new ArrayList<>();
        for(ObjectError objectError:ex.getBindingResult().getAllErrors()){
            details.add(objectError.getDefaultMessage());
        }
        ErrResponse errResponse = new ErrResponse("validation failed",details);
        return new ResponseEntity(errResponse,HttpStatus.BAD_REQUEST);

    }


}
