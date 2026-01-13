package com.example.SpringBoot_Production_Features.controller;

import com.example.SpringBoot_Production_Features.entity.Post;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/audit")
public class AuditController {

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/posts/{postId}")
    public List<Post> getPostRevisions(@PathVariable Long postId) {

        AuditReader reader = AuditReaderFactory.get(entityManager);

        List<Number> revisions = reader.getRevisions(Post.class, postId);

        return revisions.stream()
                .map(rev -> reader.find(Post.class, postId, rev))
                .collect(Collectors.toList());
    }
}
