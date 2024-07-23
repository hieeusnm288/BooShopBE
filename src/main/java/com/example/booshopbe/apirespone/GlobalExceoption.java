package com.example.booshopbe.apirespone;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class GlobalExceoption extends RuntimeException{

    public GlobalExceoption(String message) {
        super(message);
    }

}
