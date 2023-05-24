package com.example.springdataexamples.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springdataexamples.DTO.PostWithUserNameAndEmailDTO;
import com.example.springdataexamples.DTO.PostWithUserNameDTO;
import com.example.springdataexamples.DTO.UserDTO;
import com.example.springdataexamples.Myutils.DataGenerator;
import com.example.springdataexamples.mapper.MapperFacade;
import com.example.springdataexamples.mapper.PostWithUserNameMapper;
import com.example.springdataexamples.mapper.UserMapper;
import com.example.springdataexamples.model.Comment;
import com.example.springdataexamples.model.Post;
import com.example.springdataexamples.model.User;
import com.example.springdataexamples.repository.CommentRepository;
import com.example.springdataexamples.repository.PostRepository;
import com.example.springdataexamples.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class AppService {

  private final UserRepository userRepository;
  private final PostRepository postRepository;
  private final CommentRepository commentRepository;

  private final MapperFacade mapperFacade;

  public AppService(
      UserRepository userRepository,
      PostRepository postRepository,
      CommentRepository commentRepository,
      MapperFacade mapperFacade) {
    this.userRepository = userRepository;
    this.postRepository = postRepository;
    this.commentRepository = commentRepository;
    this.mapperFacade = mapperFacade;
  }


  public List<UserDTO> getAllUsersDTO() {
    List<User> users = userRepository.findAll();
    return mapperFacade.toUserDTO(users);
  }

  public List<PostWithUserNameDTO> getAllPostsWithUserDTO() {
    List<Post> posts = postRepository.findAll();
    return mapperFacade.toPostWithUserDTO(posts);
  }

  public List<PostWithUserNameAndEmailDTO> getAllPostsWithUserNameAndEmailDTO() {
    List<Post> posts = postRepository.findAll();
    return mapperFacade.toPostWithUserNameAndEmailMapper(posts);
  }

  public void populateDatabase() {
    DataGenerator dataGenerator = new DataGenerator();

    List<User> users = dataGenerator.generateUsers();
    List<Post> posts = dataGenerator.generatePosts(users);
    List<Comment> comments = dataGenerator.generateComments(posts, users);

    userRepository.saveAll(users);
    postRepository.saveAll(posts);
    commentRepository.saveAll(comments);
  }

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public List<Post> getAllPosts() {
    return postRepository.findAll();
  }

  public List<Comment> getAllComments() {
    return commentRepository.findAll();
  }
}
