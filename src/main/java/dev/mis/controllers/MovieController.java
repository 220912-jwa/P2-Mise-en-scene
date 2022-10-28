package dev.mis.controllers;

import dev.mis.entities.Movie;
import dev.mis.services.MovieService;
import io.javalin.http.Context;
import io.javalin.http.HttpCode;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class MovieController {
    private MovieService ms;
    public MovieController(MovieService ms){this.ms=ms;}
    public void createMovie(Context ctx){
        Movie movie = ctx.bodyAsClass(Movie.class);
        Movie newMovie = ms.createMovie(movie);
        ctx.status(HttpCode.CREATED);
        ctx.json(newMovie);
    }
    public void searchMovieById(Context ctx) throws IOException, ExecutionException, InterruptedException {
        String movieID = ctx.pathParam("movie_id");
        ctx.status(200);
        ctx.json(ms.searchMovieById(movieID));
    }
    public void updateMovie(Context ctx){
        Movie movie = ctx.bodyAsClass(Movie.class);
        ms.updateMovie(movie);
        ctx.status(HttpCode.NO_CONTENT);
    }
    public void deleteMovie(Context ctx){
        String movieID = ctx.pathParam("movie_id");
        ms.deleteMovie(movieID);
        ctx.status(HttpCode.NO_CONTENT);
    }
}
