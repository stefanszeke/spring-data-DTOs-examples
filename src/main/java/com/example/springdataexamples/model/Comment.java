package com.example.springdataexamples.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "comments")
public class Comment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String reply;

  @ManyToOne
  @JoinColumn(name = "post_id")
  @JsonIgnoreProperties({ "comments", "user" })
  private Post post;

  @ManyToOne
  @JoinColumn(name = "user_id")
  @JsonIgnoreProperties("comment")
  private User user;

  public Comment(String reply, Post post, User user) {
    this.reply = reply;
    this.post = post;
    this.user = user;
  }
}
