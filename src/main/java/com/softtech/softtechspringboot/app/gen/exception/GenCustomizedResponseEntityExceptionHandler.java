package com.softtech.softtechspringboot.app.gen.exception;

import com.softtech.softtechspringboot.learning.exception.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.Objects;


//bunlar uygulamanın herhangi bir yerinde olur da bir exception alırsa bunu yakalamaya yarıyor.
@RestController
@ControllerAdvice
public class GenCustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest webRequest){

        Date errorDate = new Date();
        String message = ex.getMessage();
        String description = webRequest.getDescription(false);

        GenExceptionResponse genExceptionResponse = new GenExceptionResponse(errorDate, message, description);

        return new ResponseEntity<>(genExceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleAllUserNotFoundException(UserNotFoundException ex, WebRequest webRequest){

        Date errorDate = new Date();
        String message = ex.getMessage();
        String description = webRequest.getDescription(false);

        GenExceptionResponse genExceptionResponse = new GenExceptionResponse(errorDate, message, description);


        return new ResponseEntity<>(genExceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,HttpStatus status) {

        Date errorDate = new Date();
        String message = "Validation failed!";
        String description = ex.getBindingResult().toString();

        GenExceptionResponse genExceptionResponse = new GenExceptionResponse(errorDate, message, description);


        return new ResponseEntity<>(genExceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
