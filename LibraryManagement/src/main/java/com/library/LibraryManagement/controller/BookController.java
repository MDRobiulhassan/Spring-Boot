package com.library.LibraryManagement.controller;


import com.library.LibraryManagement.dto.book.BookRequestDTO;
import com.library.LibraryManagement.dto.book.BookResponseDTO;
import com.library.LibraryManagement.serviceimpl.BookServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class BookController {

    private final BookServiceImpl bookService;

    public BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/book")
    public ResponseEntity<?> createBook(@RequestBody BookRequestDTO bookRequestDTO) {
        return new ResponseEntity<>(bookService.createBook(bookRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping("/book")
    public ResponseEntity<?> getAllBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<?> getBookById(@RequestParam Long id) {
        return new ResponseEntity<>(bookService.getBookById(id), HttpStatus.OK);
    }
}
