package dev.mis.daos;

import dev.mis.entities.Movie;

public class MovieDAO {
    public Movie createMovie(){}
    public Movie getMovieById(int movieID){}
    //should check DB first, and catch SQL exception by sending movieID prefaced with "tt" to OMDB API
    public boolean updateMovie(Movie movie){}

    public boolean deleteMovie(int movieID){}
}
