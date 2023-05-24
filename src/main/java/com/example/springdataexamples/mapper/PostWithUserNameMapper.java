package com.example.springdataexamples.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.springdataexamples.DTO.PostWithUserNameDTO;
import com.example.springdataexamples.model.Post;

@Mapper(componentModel = "spring")
public interface PostWithUserNameMapper {

  @Mapping(source = "user.name", target = "userName")

  PostWithUserNameDTO toPostWithUserDTO(Post post);
  List<PostWithUserNameDTO> toPostWithUserDTOs(List<Post> posts);
}
