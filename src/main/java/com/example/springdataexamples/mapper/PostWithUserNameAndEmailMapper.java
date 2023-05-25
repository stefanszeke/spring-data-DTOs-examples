package com.example.springdataexamples.mapper;


import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.springdataexamples.DTO.PostWithUserNameAndEmailDTO;
import com.example.springdataexamples.model.Post;

@Mapper(componentModel = "spring")
public interface PostWithUserNameAndEmailMapper {

  @Mapping(source = "user.firstName", target = "firstName")
  @Mapping(source = "user.lastName", target = "lastName")
  @Mapping(source = "user.email", target = "email")
  @Mapping(source = "commentsCount", target = "comments" ) // form getter method: getCommentsCount()


  PostWithUserNameAndEmailDTO toPostWithUserNameAndEmailDTOr(Post post);
  List<PostWithUserNameAndEmailDTO> toPostWithUserNameAndEmailDTO(List<Post> posts);  
}
