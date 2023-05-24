package com.example.springdataexamples.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostWithUserNameAndEmailDTO {
  private Long id;
  private String subject;
  private int comments;
  private String userName;
  private String email;
}
