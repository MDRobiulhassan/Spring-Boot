package com.example.SpringBoot_Production_Features.service;

import com.example.SpringBoot_Production_Features.dto.PostDTO;
import com.example.SpringBoot_Production_Features.dto.PostResponseDTO;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface PostService {
    List<PostResponseDTO> getAllPost();
    PostResponseDTO createPost(PostDTO postDTO);
    PostResponseDTO getPostById(Long id);

    PostResponseDTO updatePost(PostDTO postDTO, Long id);
}
