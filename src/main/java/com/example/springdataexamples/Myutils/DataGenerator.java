package com.example.springdataexamples.Myutils;

import java.util.ArrayList;
import java.util.List;

import com.example.springdataexamples.model.Comment;
import com.example.springdataexamples.model.Post;
import com.example.springdataexamples.model.User;
import com.github.javafaker.Faker;

public class DataGenerator {
  private static final int NUM_USERS = 3;
  private static final int MAX_POSTS_PER_USER = 5;
  private static final int MAX_COMMENTS_PER_POST = 3;

  private final Faker faker;

  public DataGenerator() {
    this.faker = new Faker();
  }

  public List<User> generateUsers() {
    List<User> users = new ArrayList<>();

    for (int i = 0; i < NUM_USERS; i++) {
      String firstName = faker.name().firstName();
      String lastName = faker.name().lastName();
      String email = lastName.toLowerCase() + "@example.com";

      User user = new User(firstName, lastName, email);
      users.add(user);
    }

    return users;
  }

  public List<Post> generatePosts(List<User> users) {
    List<Post> posts = new ArrayList<>();

    for (User user : users) {
      int numPosts = faker.number().numberBetween(1, MAX_POSTS_PER_USER + 1);

      for (int i = 0; i < numPosts; i++) {
        String subject = faker.lorem().sentence(3);
        Post post = new Post(subject, user);

        posts.add(post);
      }
    }

    return posts;
  }

  public List<Comment> generateComments(List<Post> posts, List<User> users) {
    List<Comment> comments = new ArrayList<>();

    for (Post post : posts) {
      int numComments = faker.number().numberBetween(1, MAX_COMMENTS_PER_POST + 1);

      for (int i = 0; i < numComments; i++) {
        String reply = faker.lorem().sentence(5);
        int randomUserIndex = faker.random().nextInt(users.size());
        User user = users.get(randomUserIndex);
        Comment comment = new Comment(reply, post, user);
        comments.add(comment);
      }
    }

    return comments;
  }

}
