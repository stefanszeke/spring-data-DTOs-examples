package com.example.springdataexamples.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.springdataexamples.DTO.PostWithUserNameDTO;
import com.example.springdataexamples.model.Post;

@Mapper(componentModel = "spring")
public interface PostWithUserNameMapper {

  @Mapping(expression = "java(post.getUser().getFirstName() + ' ' + post.getUser().getLastName())", target = "userName")
  PostWithUserNameDTO toPostWithUserNameDTO(Post post);
  List<PostWithUserNameDTO> toPostWithUserNameDTOs(List<Post> posts);
}
