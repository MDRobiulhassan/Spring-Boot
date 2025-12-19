package com.library.LibraryManagement.dto.book;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookRequestDTO {
    private String title;
    private LocalDate publishedDate;
    private Long authorId;
}
