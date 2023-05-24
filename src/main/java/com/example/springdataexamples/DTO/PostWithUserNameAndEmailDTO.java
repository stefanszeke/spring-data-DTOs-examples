package com.example.springdataexamples.DTO;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostWithUserNameAndEmailDTO {
  private Long id;
  private String subject;
  private List<CommentDTO> comments;
  private String userName;
  private String email;
}
