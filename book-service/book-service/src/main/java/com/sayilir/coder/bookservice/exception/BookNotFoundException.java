package com.sayilir.coder.bookservice.exception;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String s) {
        super(s);
    }
}
