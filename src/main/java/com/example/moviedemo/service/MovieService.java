package com.example.moviedemo.service;


import com.example.moviedemo.model.Movie;
import com.example.moviedemo.model.PopularMovie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;


@Slf4j
@Service
public class MovieService {

    WebClient webClient;
    RestTemplate restTemplate;

    private final String apiKey = "f379c50b4612bca1d8abc73f673ebc48";

    @Autowired
    public MovieService(WebClient webClient, RestTemplate restTemplate) {
        this.webClient = webClient;
        this.restTemplate = restTemplate;
    }

    public Mono<Movie> findMovie(final String movieId) {
        log.info("Searching movie with id: [{}]", movieId);

//        Mono<Movie> monoMovie = Mono.just(restTemplate.getForObject("https://api.themoviedb.org/3/movie/"+ movieId + "?api_key=" + apiKey, Movie.class));

        Mono<Movie> result = webClient.get()
                .uri(String.format("/movie/%s?api_key=f379c50b4612bca1d8abc73f673ebc48", movieId))
                .retrieve()
                .bodyToMono(Movie.class);

        return result;
    }


    public Mono<ResponseEntity<String>> findPopular() {
        log.info("Searching for popular movies");

//        Mono<String> result = webClient.get()
//                .uri("/movie/top_rated?api_key=f379c50b4612bca1d8abc73f673ebc48")
//                .retrieve()
//                .bodyToMono(String.class);

        String url = "https://api.themoviedb.org/3/movie/top_rated" + "?api_key=" + apiKey;

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        Mono<ResponseEntity<String>> res = Mono.just(restTemplate.exchange(url, HttpMethod.GET, entity, String.class));

        return res;
//
    }
}