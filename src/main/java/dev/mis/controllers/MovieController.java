package dev.mis.controllers;

import dev.mis.services.MovieService;

public class MovieController {
    private MovieService ms;
    public MovieController(MovieService ms){this.ms=ms;}
}
