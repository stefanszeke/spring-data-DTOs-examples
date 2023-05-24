package com.example.springdataexamples.mapper;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springdataexamples.DTO.PostWithUserNameAndEmailDTO;
import com.example.springdataexamples.DTO.PostWithUserNameDTO;
import com.example.springdataexamples.DTO.UserDTO;
import com.example.springdataexamples.model.Post;
import com.example.springdataexamples.model.User;

@Service
public class MapperFacade {

  private UserMapper userMapper;
  private PostWithUserNameMapper postWithUserNameMapper;
  private PostWithUserNameAndEmailMapper postWithUserNameAndEmailMapper;

  public MapperFacade(
      UserMapper userMapper,
      PostWithUserNameMapper postWithUserNameMapper,
      PostWithUserNameAndEmailMapper postWithUserNameAndEmailMapper) {
    this.userMapper = userMapper;
    this.postWithUserNameMapper = postWithUserNameMapper;
    this.postWithUserNameAndEmailMapper = postWithUserNameAndEmailMapper;
  }

  public List<UserDTO> toUserDTO(List<User> users) {
    return userMapper.toUserDTOs(users);
  }

  public List<PostWithUserNameDTO> toPostWithUserDTO(List<Post> posts) {
    return postWithUserNameMapper.toPostWithUserNameDTOs(posts);
  }

  public List<PostWithUserNameAndEmailDTO> toPostWithUserNameAndEmailMapper(List<Post> posts) {
    return postWithUserNameAndEmailMapper.toPostWithUserNameAndEmailDTO(posts);
  }


  


}
