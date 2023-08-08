package com.example.first_pro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class FirstProApplication {

  public static void main(String[] args) {
    SpringApplication.run(FirstProApplication.class, args);
  }
}
