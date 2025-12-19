package com.library.LibraryManagement.dto.author;

import com.library.LibraryManagement.dto.book.BookResponseDTO;
import lombok.Data;

import java.util.List;

@Data
public class AuthorResponseDTO {
    private Long id;
    private String name;
    private List<BookResponseDTO> books;
}
