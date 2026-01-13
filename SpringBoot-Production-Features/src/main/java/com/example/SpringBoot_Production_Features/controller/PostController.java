package com.example.SpringBoot_Production_Features.controller;

import com.example.SpringBoot_Production_Features.dto.PostDTO;
import com.example.SpringBoot_Production_Features.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @GetMapping
    public ResponseEntity<?> getAllPosts(){
        return ResponseEntity.ok(postService.getAllPost());
    }

    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody PostDTO postDTO){
        return ResponseEntity.ok(postService.createPost(postDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPostById(@PathVariable Long id){
        return ResponseEntity.ok(postService.getPostById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePost(@RequestBody PostDTO postDTO, @PathVariable Long id){
        return ResponseEntity.ok(postService.updatePost(postDTO,id));
    }
}
