package com.example.moviedemo.model;

import lombok.Data;

import java.util.List;

@Data
public class Movie {

    private String imdb_id;
    private String original_title;
    private String homepage;
    private List<Country> production_countries;
}

