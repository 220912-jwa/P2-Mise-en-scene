package dev.mis.services;

import dev.mis.daos.LibraryEntryDAO;
import dev.mis.daos.MovieDAO;
import dev.mis.daos.UserDAO;
import dev.mis.entities.LibraryEntry;

import java.util.List;

public class LibraryEntryService {

    private LibraryEntryDAO libraryEntryDAO;
    private MovieDAO movieDAO;
    private UserDAO userDAO;

    public LibraryEntryService(UserDAO userDAO, MovieDAO movieDAO, LibraryEntryDAO libraryEntryDAO){
        this.userDAO = userDAO;
        this.movieDAO = movieDAO;
        this.libraryEntryDAO = libraryEntryDAO;
    }

    public List<LibraryEntry> getUserEntriesByCode(String userCode){
        // takes userCode, finds userId, then retrieves all library entries
        return null; //just to build
    }
    public List<LibraryEntry> getLibraryById(int userID){
        return null; //just to build
    }

    public void editLibraryEntry(int userId, String movieId){

    }

    public void deleteLibraryEntry(int userId, String movieId){

    }
}
