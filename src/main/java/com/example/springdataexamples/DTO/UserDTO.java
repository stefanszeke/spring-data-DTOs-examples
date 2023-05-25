package com.example.springdataexamples.DTO;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {
  private long id;
  private String firstName;
  private String lastName;
  private String email;
  private List<PostDTO> posts;
}
