package com.library.LibraryManagement.dto.book;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BookRequestDTO {
    private String title;

    @JsonAlias("publish_date")
    private LocalDate publishedDate;
    private Long authorId;
}
