package com.example.userorg.customException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<?> resourceNotFoundHandling(ResourceNotFound exception, WebRequest request){
        ErrorDetail ErrorDetail = new ErrorDetail(new Date(), exception.getMessage(),request.getDescription(false));

        return new ResponseEntity<>(ErrorDetail, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalExceptionHandling(Exception exception, WebRequest request){
        ErrorDetail ErrorDetail =
                new ErrorDetail(new Date(), exception.getMessage(),request.getDescription(false) );
        return new ResponseEntity<>(ErrorDetail, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDetail> handleEntitiyException(MethodArgumentNotValidException ex){

        ErrorDetail ValidationError = new ErrorDetail("validation error",
                ex.getBindingResult().getFieldError().getDefaultMessage(),HttpStatus.BAD_REQUEST);

        return new ResponseEntity<ErrorDetail>(ValidationError, HttpStatus.BAD_REQUEST);


    }
}
