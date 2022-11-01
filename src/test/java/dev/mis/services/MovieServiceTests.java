package dev.mis.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import dev.mis.daos.MovieDAO;
import dev.mis.services.MovieService;
import dev.mis.entities.Movie;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
public class MovieServiceTests {

    @InjectMocks
    private static MovieService ms;

    @Mock
    private static MovieDAO mockMovieDAO;

    private static Movie mockMovieEntity;

    @BeforeAll
    public static void setup(){
        mockMovieDAO = new MovieDAO();
    }

    @BeforeEach
    public void mockMovieBeforeEach(){
        mockMovieEntity = new Movie("t1234","The Revenge of P1",3.5F, "English", 2022);
    }

    @Test
    public void testCreateMovie(){
        when(mockMovieDAO.createMovie(mockMovieEntity)).thenReturn(mockMovieEntity);
        Movie newMovie = ms.createMovie(mockMovieEntity);
        assertNotNull(newMovie);
    }

    @Test
    public void testGetMovieByID() throws ExecutionException, InterruptedException, JsonProcessingException {
        when(mockMovieDAO.getMovieById("tt10823255")).thenReturn(mockMovieEntity);
        Movie gottenMovie = ms.searchMovieById("tt10823255");
        assertNotNull(gottenMovie);
    }

    @Test
    public void testUpdateMovie(){
        when(mockMovieDAO.updateMovie(mockMovieEntity)).thenReturn(true);
        boolean updatedMovie = ms.updateMovie(mockMovieEntity);
        assertTrue(updatedMovie);
    }

    @Test
    public void testDeleteMovie(){
        when(mockMovieDAO.deleteMovie("tt01082555")).thenReturn(true);
        boolean deletedMovie = ms.deleteMovie("tt01082555");
        assertTrue(deletedMovie);
    }
}
