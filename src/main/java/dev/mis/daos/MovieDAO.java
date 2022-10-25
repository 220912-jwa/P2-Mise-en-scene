package dev.mis.daos;

import dev.mis.entities.Movie;

public class MovieDAO {
    public Movie createMovie(){
        // Should include a way to generate an integer id
    }
    public Movie getMovieById(String movieID){}
    //should check DB first, and catch SQL exception by sending movieID prefaced with "tt" to OMDB API
    public boolean updateMovie(Movie movie){}

    public boolean deleteMovie(String movieID){}
}
