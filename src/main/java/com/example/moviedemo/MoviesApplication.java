package com.example.moviedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration
@SpringBootApplication
@Configuration
public class MoviesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoviesApplication.class, args);
    }
}
