package com.example.springdataexamples.model;


import java.util.ArrayList;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String name;

  private String email;

  @OneToMany(mappedBy = "user"
  )
  @JsonIgnoreProperties("user") // This is needed to avoid infinite recursion
  private List<Post> posts = new ArrayList<>();

  @OneToMany(mappedBy = "user"
  )
  @JsonIgnoreProperties("user")
  private List<Comment> comments = new ArrayList<>();

  public User(String name, String email) {
    this.email = email;
    this.name = name;
  }
  
}

