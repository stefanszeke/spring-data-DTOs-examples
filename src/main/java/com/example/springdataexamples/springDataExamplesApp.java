package com.example.springdataexamples;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.springdataexamples.service.AppService;

@SpringBootApplication
public class springDataExamplesApp implements CommandLineRunner {

  @Autowired
  private AppService appService;  


	public static void main(String[] args) {
		SpringApplication.run(springDataExamplesApp.class, args);
    System.out.println("\nServer running\n");
	}

  @Override
  public void run(String... args) {

    System.out.println("\nPopulating database...\n");
    appService.populateDatabase();
  }

}
