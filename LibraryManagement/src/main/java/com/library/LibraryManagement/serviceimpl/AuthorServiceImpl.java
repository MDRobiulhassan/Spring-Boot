package com.library.LibraryManagement.serviceimpl;

import com.library.LibraryManagement.dto.author.AuthorRequestDTO;
import com.library.LibraryManagement.dto.author.AuthorResponseDTO;
import com.library.LibraryManagement.entity.Author;
import com.library.LibraryManagement.repository.AuthorRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl {

    private final AuthorRepository authorRepository;
    private final ModelMapper modelMapper;

    public AuthorServiceImpl(AuthorRepository authorRepository, ModelMapper modelMapper) {
        this.authorRepository = authorRepository;
        this.modelMapper = modelMapper;
    }


    @Transactional
    public AuthorResponseDTO createAuthor(AuthorRequestDTO authorRequestDTO) {
        Author author = modelMapper.map(authorRequestDTO, Author.class);
        Author saved = authorRepository.save(author);
        return modelMapper.map(saved, AuthorResponseDTO.class);
    }

    @Transactional
    public List<AuthorResponseDTO> getAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        return authors.stream().map(
                author -> modelMapper.map(author, AuthorResponseDTO.class)).toList();
    }
}
