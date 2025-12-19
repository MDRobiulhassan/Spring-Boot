package com.library.LibraryManagement.controller;

import com.library.LibraryManagement.dto.author.AuthorRequestDTO;
import com.library.LibraryManagement.serviceimpl.AuthorServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/library")
public class AuthorController {

    private final AuthorServiceImpl authorService;

    public AuthorController(AuthorServiceImpl authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/author")
    public ResponseEntity<?> createAuthor(@RequestBody AuthorRequestDTO authorRequestDTO) {
        return new ResponseEntity<>(authorService.createAuthor(authorRequestDTO), HttpStatus.CREATED);
    }
}
