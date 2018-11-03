package com.example.moviedemo.controller;

import com.example.moviedemo.model.Movie;
import com.example.moviedemo.model.PopularMovie;
import com.example.moviedemo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController("movie")
public class MovieController {

    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public Mono<Movie> getMovie(@RequestParam String id){
        return movieService.findMovie(id);
    }

    @GetMapping("/popular")
    public Mono<ResponseEntity<String>> getPopular(){
        return movieService.findPopular();
    }
}
