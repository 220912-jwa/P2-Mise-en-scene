package dev.mis.services;

import dev.mis.daos.MovieDAO;
import dev.mis.entities.Movie;


import java.sql.SQLException;



public class MovieService {
    private MovieDAO movieDAO;
    public MovieService(MovieDAO movieDAO){this.movieDAO=movieDAO;}

    public Movie createMovie(Movie movie){
        return movieDAO.createMovie(movie);}
    public boolean updateMovie(Movie movie){
        return movieDAO.updateMovie(movie);
    }
    public boolean deleteMovie(String movieID){
    return  movieDAO.deleteMovie(movieID);}



    public Movie searchMovieById(String movieID){
        Movie movie =  movieDAO.getMovieById(movieID);
        if (movie != null){return movie;}else{
            //JDBC version of fetch request goes here
            return movie;

        }

    //this is the Dynamic Search mentioned in business requirements
}
}
