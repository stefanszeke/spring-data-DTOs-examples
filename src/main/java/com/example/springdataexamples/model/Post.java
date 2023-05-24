package com.example.springdataexamples.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "posts")
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String subject;

  @OneToMany(mappedBy = "post")
  @JsonIgnoreProperties({ "post", "user" })
  private List<Comment> comments = new ArrayList<>();

  @ManyToOne
  @JoinColumn(name = "user_id")
  @JsonIgnoreProperties("post") // This is needed to avoid infinite recursion
  private User user;

  public Post(String subject, User user) {
    this.subject = subject;
    this.user = user;
  }

  public int getCommentsCount() {
    return comments.size();
  }

}
