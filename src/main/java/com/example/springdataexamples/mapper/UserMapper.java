package com.example.springdataexamples.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.springdataexamples.DTO.UserDTO;
import com.example.springdataexamples.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
  UserDTO toUserDTO(User user);
  List<UserDTO> toUserDTOs(List<User> users);
}
