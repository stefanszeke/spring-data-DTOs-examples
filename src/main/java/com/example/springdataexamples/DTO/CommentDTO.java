package com.example.springdataexamples.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentDTO {
  private Long id;
  private String reply;
}
