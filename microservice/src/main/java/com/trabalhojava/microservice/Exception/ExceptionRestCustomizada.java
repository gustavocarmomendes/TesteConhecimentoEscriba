package com.trabalhojava.microservice.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ExceptionRestCustomizada {
    
    @ExceptionHandler(ExceptionCustomizada.class)
    public ResponseEntity<String> handleCustomException(ExceptionCustomizada ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

}


