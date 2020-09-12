package info.practice.springzoo.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class AnimalRestControllerExceptionHandler {

    public static final String VALIDATION_ERROR = "VALIDATION_ERROR";
    public static final String ERROR = "RUNTIME_ERROR";

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    ErrorResponse handleValidationException(MethodArgumentNotValidException exception){
        return ErrorResponse.builder()
                .code(VALIDATION_ERROR)
                .message(exception.getMessage())
                .build();

    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    ErrorResponse handleRuntimeException(Exception exception){
        return ErrorResponse.builder()
                .code(ERROR)
                .message(exception.getMessage())
                .build();

    }
}
