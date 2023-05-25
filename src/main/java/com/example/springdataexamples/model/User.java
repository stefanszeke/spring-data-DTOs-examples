package com.example.springdataexamples.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
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

  private String firstName;

  private String lastName;

  private String email;

  @OneToMany(mappedBy = "user")
  @JsonIgnoreProperties("user") // This is needed to avoid infinite recursion
  private List<Post> posts = new ArrayList<>();

  @OneToMany(mappedBy = "user")
  @JsonIgnoreProperties("user")
  private List<Comment> comments = new ArrayList<>();

  public User(String firstName, String lastName, String email) {
    this.email = email;
    this.firstName = firstName;
    this.lastName = lastName;
  }

}
