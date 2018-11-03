package com.example.moviedemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ConfigClass {

    @Bean
    public WebClient getWebClient() {
        return WebClient.create("https://api.themoviedb.org/3");
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
