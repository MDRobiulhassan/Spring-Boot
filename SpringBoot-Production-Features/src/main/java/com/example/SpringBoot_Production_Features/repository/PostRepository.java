package com.example.SpringBoot_Production_Features.repository;

import com.example.SpringBoot_Production_Features.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
}
