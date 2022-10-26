package dev.mis.services;

import dev.mis.daos.LibraryEntryDAO;
import dev.mis.daos.MovieDAO;
import dev.mis.daos.UserDAO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class LibraryEntryServiceUnitTests {

    @InjectMocks
    private static LibraryEntryService les;

    @Mock
    private static LibraryEntryDAO leDAO;
    private static UserDAO uDAO;
    private static MovieDAO mDAO;

    @BeforeAll
    public static void setup(){
        uDAO = new UserDAO();
        mDAO = new MovieDAO();
        leDAO = new LibraryEntryDAO();
        les = new LibraryEntryService(uDAO, mDAO, leDAO);
    }

    @Test
    public void createEntry(){

    }

    @Test
    public void deleteEntry(){

    }

    @Test void getEntriesByCode(){

    }
}
