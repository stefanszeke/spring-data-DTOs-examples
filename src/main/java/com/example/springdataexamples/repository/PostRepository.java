package com.example.springdataexamples.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springdataexamples.model.Post;

public interface PostRepository extends JpaRepository<Post, Long>{
  
}
