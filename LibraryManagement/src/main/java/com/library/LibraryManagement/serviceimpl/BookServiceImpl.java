package com.library.LibraryManagement.serviceimpl;

import com.library.LibraryManagement.dto.book.BookRequestDTO;
import com.library.LibraryManagement.dto.book.BookResponseDTO;
import com.library.LibraryManagement.entity.Author;
import com.library.LibraryManagement.entity.Book;
import com.library.LibraryManagement.repository.AuthorRepository;
import com.library.LibraryManagement.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final ModelMapper modelMapper;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.modelMapper = modelMapper;
    }


    @Transactional
    public BookResponseDTO createBook(BookRequestDTO dto) {
        Author author = authorRepository.findById(dto.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Author not found"));

        Book book = modelMapper.map(dto, Book.class);
        book.setId(null);
        book.setPublishDate(dto.getPublishedDate());
        book.setAuthor(author);

        Book savedBook = bookRepository.save(book);

        return modelMapper.map(savedBook, BookResponseDTO.class);
    }

    @Transactional
    public List<BookResponseDTO> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream().
                map(book -> modelMapper.map(book,BookResponseDTO.class)).toList();
    }

}
