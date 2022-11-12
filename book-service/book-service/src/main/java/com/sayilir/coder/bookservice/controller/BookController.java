package com.sayilir.coder.bookservice.controller;

import com.sayilir.coder.bookservice.dto.BookDto;
import com.sayilir.coder.bookservice.dto.BookIdDto;
import com.sayilir.coder.bookservice.model.Book;
import com.sayilir.coder.bookservice.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@RequestMapping("/v1/book")
public class BookController {
    Logger logger = LoggerFactory.getLogger(BookController.class);
    private final BookService bookService;


    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public ResponseEntity<List<BookDto>> getAllBook() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/isbn/{isbn}")
    // ISBN ile book id yi getirdik
    public ResponseEntity<BookIdDto> getBookByIsbn(@PathVariable @NotEmpty String isbn) {
        logger.info("Book Controller requested by isbn: " + isbn);
        return ResponseEntity.ok(bookService.findByIsbn(isbn));
    }

    @GetMapping("/book/{id}")
    //bookid ile bookDTo getiyoruz
    public ResponseEntity<BookDto> getBookById(@PathVariable @NotEmpty String id) {
        return ResponseEntity.ok(bookService.findBookDetailsById(id));
    }

}
