package dev.mis.services;


import com.google.gson.*;
import dev.mis.daos.MovieDAO;
import dev.mis.entities.Movie;
import dev.mis.entities.OJson;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


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



    public Movie searchMovieById(String movieID) throws ExecutionException, InterruptedException{
        Movie movie =  movieDAO.getMovieById(movieID); //if movie is already in DB
        if (movie != null){return movie;}else{
           String uri = "http://www.omdbapi.com/?i="+movieID+"&apikey=9c0cebf2";
           HttpClient client = HttpClient.newHttpClient();
           HttpRequest request = HttpRequest.newBuilder(
                   URI.create(uri))
                   .header("accept","application/json").build();
           CompletableFuture<HttpResponse<String>> res = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
           HttpResponse<String> response = res.get();
           String resStr=response.body();
           Gson gson = new Gson();
           OJson oMovie = gson.fromJson(resStr, OJson.class);
           String strMovieId = "'"+movieID+"'";
           Movie newMovie = new Movie(strMovieId,oMovie.getTitle(),Float.valueOf(oMovie.getImdbRating()),oMovie.getLanguage(),Integer.parseInt(oMovie.getYear()));
           System.out.println(newMovie);
          movieDAO.createMovie(newMovie);
          //adds new movie to database
           return newMovie;
        }
    //this is the Dynamic Search mentioned in business requirements
    }


}
