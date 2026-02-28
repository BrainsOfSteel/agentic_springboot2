package com.example.repository;

import com.example.entity.inheritance.Post;
import com.example.entity.inheritance.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findById(Long id);
}
