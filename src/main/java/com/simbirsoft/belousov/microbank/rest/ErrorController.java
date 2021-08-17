package com.simbirsoft.belousov.microbank.rest;

import com.simbirsoft.belousov.microbank.rest.exeption_handing.LowBalance;
import com.simbirsoft.belousov.microbank.rest.exeption_handing.NoSuchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(IOException.class)
    public ResponseEntity<String> handleIOException(IOException e) {
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchException.class)
    public ResponseEntity<String> handleNoSuchException(NoSuchException e) {
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(LowBalance.class)
    public ResponseEntity<String> handleLowBalance(LowBalance e) {
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}