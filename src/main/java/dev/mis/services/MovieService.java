package dev.mis.services;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import com.google.gson.JsonArray;
import com.google.gson.stream.JsonReader;
import dev.mis.daos.MovieDAO;
import dev.mis.entities.Movie;
import dev.mis.entities.OJson;
import dev.mis.entities.OMovie;


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



    public Movie searchMovieById(String movieID) throws ExecutionException, InterruptedException, IOException {
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
           System.out.println(resStr);
           //JsonObject jsonRes = new JsonObject(response);
           //String jsonRes =gson.toJson(res);
          OJson oMovie = gson.fromJson(resStr, OJson.class);
            System.out.println(oMovie);
           String strMovieId = "'"+movieID+"'";
           Movie newMovie = new Movie(strMovieId,oMovie.getTitle(),Float.valueOf(oMovie.getImdbRating()),oMovie.getLanguage(),Integer.parseInt(oMovie.getYear()));
           System.out.println(newMovie);
           //this WILL work, provided Movie class variable names are renamed. Alternatives: make new OMDBMovie class
            //Getting Ratings to work will also be difficult as it is stored as separate object
            //Perhaps parsing as String and getting creative with regex .split() is the way
            //String[] movieKeys = response.toString().split(",:",0);
            //Movie newMovie = new Movie(movieID,movieKeys[1],movieKeys[1],movieKeys[1],Integer.parseInt(movieKeys[3]));
           movieDAO.createMovie(newMovie);
           //return newMovie;
            return newMovie;
        }

    //this is the Dynamic Search mentioned in business requirements
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException, JsonIOException {
        MovieDAO movieDAO1 = new MovieDAO();
        MovieService ms = new MovieService(movieDAO1);
        ms.searchMovieById("tt5108870");
    }
}
