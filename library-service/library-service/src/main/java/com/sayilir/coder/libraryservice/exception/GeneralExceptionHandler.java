package com.sayilir.coder.libraryservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@RestControllerAdvice
public class GeneralExceptionHandler {
    //uygulama esnasında uretilen bir thorow edilen bir uygun bir rest response una ceviriyoruz
    @ExceptionHandler(LibraryNotFoundException.class)
    public ResponseEntity<?> handle(LibraryNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    //SPring BookNotFOund için hangi method handle edecegini bilemez bu yüzden hata fırlatır
    //Bunda dolayı her method icin sadece bir handle nethodun olsun
   /* @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<String> handle(BookNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
*/

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ExceptionMessage> handle(BookNotFoundException exception) {
        return new ResponseEntity<>(exception.getExceptionMessage(),
                Objects.requireNonNull(HttpStatus.resolve(exception.getExceptionMessage().getStatus())));
    }

}
