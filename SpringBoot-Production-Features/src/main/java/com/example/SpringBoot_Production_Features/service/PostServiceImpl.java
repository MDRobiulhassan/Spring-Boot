package com.example.SpringBoot_Production_Features.service;

import com.example.SpringBoot_Production_Features.dto.PostDTO;
import com.example.SpringBoot_Production_Features.dto.PostResponseDTO;
import com.example.SpringBoot_Production_Features.entity.Post;
import com.example.SpringBoot_Production_Features.exceptions.ResourceNotFoundException;
import com.example.SpringBoot_Production_Features.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<PostResponseDTO> getAllPost() {
        return postRepository.findAll().
                stream().
                map(postEntity -> modelMapper.map(postEntity, PostResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostResponseDTO createPost(PostDTO postDTO) {
        Post postEntity = modelMapper.map(postDTO, Post.class);
        postEntity = postRepository.save(postEntity);
        return modelMapper.map(postEntity, PostResponseDTO.class);
    }

    @Override
    public PostResponseDTO getPostById(Long id) {
        Post postEntity = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id " + id));
        return modelMapper.map(postEntity, PostResponseDTO.class);
    }
}
