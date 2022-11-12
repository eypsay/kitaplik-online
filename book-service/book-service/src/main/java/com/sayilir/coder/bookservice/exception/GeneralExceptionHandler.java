package com.sayilir.coder.bookservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralExceptionHandler {
    //uygulama esnasında uretilen bir thorow edilen bir uygun bir rest response una ceviriyoruz
    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<?> handle(BookNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}
