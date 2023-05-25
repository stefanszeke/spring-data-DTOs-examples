package com.example.springdataexamples.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostWithUserNameAndEmailDTO {
  private Long id;
  private String subject;
  private int comments;
  private String firstName;
  private String lastName;
  private String email;
}
