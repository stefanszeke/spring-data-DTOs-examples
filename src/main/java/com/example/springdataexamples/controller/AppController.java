package com.example.springdataexamples.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdataexamples.DTO.PostWithUserNameAndEmailDTO;
import com.example.springdataexamples.DTO.PostWithUserNameDTO;
import com.example.springdataexamples.DTO.UserDTO;
import com.example.springdataexamples.model.Comment;
import com.example.springdataexamples.model.Post;
import com.example.springdataexamples.model.User;
import com.example.springdataexamples.service.AppService;

@RestController
public class AppController {

  private final AppService appService;

  public AppController(AppService appService) {
    this.appService = appService;
  }

  @GetMapping("/dto/users")
  public List<UserDTO> getAllUsers2() {
    System.out.println("\nGetting all user DTOs...\n");
    return appService.getAllUsersDTO();
  }

  @GetMapping("/dto/posts")
  public List<PostWithUserNameDTO> getAllPostsWithUserDTO() {
    System.out.println("\nGetting all posts with userName DTOs...\n");
    return appService.getAllPostsWithUserDTO();
  }

  @GetMapping("/dto/postsfull")
  public List<PostWithUserNameAndEmailDTO> getAllPostsWithUserNameAndEmailDTO() {
    System.out.println("\nGetting all posts with userName and email DTOs...\n");
    return appService.getAllPostsWithUserNameAndEmailDTO();
  }

  @GetMapping("/users")
  public List<User> getAllUsers() {
    System.out.println("\nGetting all users...\n");
    return appService.getAllUsers();
  }

  @GetMapping("/comments")
  public List<Comment> getAllComments() {
    System.out.println("\nGetting all comments...\n");
    return appService.getAllComments();
  }

  @GetMapping("/posts")
  public List<Post> getAllPosts() {
    System.out.println("\nGetting all posts...\n");
    return appService.getAllPosts();
  }

  @GetMapping("/populate")
  public void populateDatabase() {
    System.out.println("Populating database...\n");
    appService.populateDatabase();
  }

}
