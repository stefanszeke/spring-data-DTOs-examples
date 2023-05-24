package com.example.springdataexamples.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springdataexamples.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
  
}
