package com.ssb.onlineshopbackend.exception;

import com.ssb.onlineshopbackend.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionAdvice {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException e){
        ErrorResponse error = new ErrorResponse("404","Resource Not Found");
        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }
}
