package dev.mis.services;

import dev.mis.daos.LibraryEntryDAO;
import dev.mis.daos.MovieDAO;
import dev.mis.daos.UserDAO;
import dev.mis.entities.LibraryEntry;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class LibraryEntryServiceUnitTests {

    @InjectMocks
    private static LibraryEntryService mockLibraryEntryService;

    @Mock
    private static LibraryEntryDAO mockLibraryEntryDAO;
    private static UserDAO mockUserDAO;
    private static MovieDAO mockMovieDAO;

    private static LibraryEntry mockLibraryEntryEntity;

    @BeforeAll
    public static void setup(){
        mockUserDAO = new UserDAO();
        mockMovieDAO = new MovieDAO();
        mockLibraryEntryDAO = new LibraryEntryDAO();
        mockLibraryEntryService = new LibraryEntryService(mockUserDAO, mockMovieDAO, mockLibraryEntryDAO);
    }

    @BeforeEach
    public void mockObjects(){
        ArrayList<LibraryEntry> mockEntries = new ArrayList<LibraryEntry>();

    }

    @Test
    public void testCreateEntry(){

        when(mockLibraryEntryDAO.createLibraryEntry(mockLibraryEntryEntity))
    }

    public void testAddEntry(){

    }

    @Test
    public void testDeleteEntry(){

    }

    @Test
    public void testGetEntriesByCode(){

    }
}
