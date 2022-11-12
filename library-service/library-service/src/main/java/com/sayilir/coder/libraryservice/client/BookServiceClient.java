package com.sayilir.coder.libraryservice.client;

import com.sayilir.coder.libraryservice.dto.BookDto;
import com.sayilir.coder.libraryservice.dto.BookIdDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//BURASI FEIGN CLEINT
@FeignClient(name = "book-service", path = "/v1/book")
public interface BookServiceClient {

    Logger logger = LoggerFactory.getLogger(BookServiceClient.class);


    @GetMapping("/isbn/{isbn}")
    // ISBN ile book id yi getirdik
    @CircuitBreaker(name = "getBookByIsbnCircuitBreaker", fallbackMethod = "getBookFallback")
    ResponseEntity<BookIdDto> getBookByIsbn(@PathVariable(value = "isbn") String isbn);

    default ResponseEntity<BookIdDto> getBookFallback(String isbn, Exception exception) {
        logger.info("Book bot found by isbn: " + isbn + ", returning default BookDto object ");
        return ResponseEntity.ok(new BookIdDto("default-book", "default-isbn"));
    }

    @GetMapping("/book/{id}")
    //bookid ile bookDTo getiyoruz
    @CircuitBreaker(name = "getBookByIdCircuitBreaker", fallbackMethod = "getBookByIdFallback")
    ResponseEntity<BookDto> getBookById(@PathVariable(value = "id") String id);

    default ResponseEntity<BookDto> getBookByIdFallback(String id, Exception exception) {
        logger.info("Book bot found by isbn: " + id + ", returning default BookDto object ");
        return ResponseEntity.ok(new BookDto(new BookIdDto("default-book", "default-isbn")));
    }
   /* @GetMapping
    ResponseEntity<List<BookDto>> getAllBook();*/
}
