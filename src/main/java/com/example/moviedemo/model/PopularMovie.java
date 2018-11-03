package com.example.moviedemo.model;

import lombok.Data;

import java.util.List;

@Data
public class PopularMovie {

    private String vote_average;
    private String title;
    private String overview;
    private String release_date;
}

