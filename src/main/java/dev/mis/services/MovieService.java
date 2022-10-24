package dev.mis.services;

import dev.mis.daos.MovieDAO;
import dev.mis.entities.Movie;
import dev.mis.entities.MovieForUser;

public class MovieService {
    private MovieDAO movieDAO;
    public MovieService(MovieDAO movieDAO){this.movieDAO=movieDAO;}

    public Movie createMovie(Movie movie){}
    public Movie searchMovie(Movie movie){}
    //this is the Dynamic Search mentioned in business requirements
}
