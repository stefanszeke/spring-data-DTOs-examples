package com.example.springdataexamples.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springdataexamples.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{
  
}
