package dev.mis.services;

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
        ms = new MovieService();
    }

    @BeforeEach
    public void mockMovieBeforeEach(){
        mockMovieEntity = new Movie("The Revenge of P1",3.5F, "English", 2022);
    }

    @Test
    public void testCreateMovie(){
        when(mockMovieDAO.createMovie(mockMovieEntity)).thenReturn();
    }

    @Test
    public void testGetMovieByID(){

    }

    @Test
    public void testUpdateMovie(){

    }

    @Test
    public void testDeleteMovie(){

    }
}
