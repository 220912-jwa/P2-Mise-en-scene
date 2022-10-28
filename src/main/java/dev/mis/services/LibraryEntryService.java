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

    public LibraryEntryService(){}

    public LibraryEntryService(UserDAO userDAO, MovieDAO movieDAO, LibraryEntryDAO libraryEntryDAO){
        this.userDAO = userDAO;
        this.movieDAO = movieDAO;
        this.libraryEntryDAO = libraryEntryDAO;
    }

    public LibraryEntry createLibraryEntry(LibraryEntry libraryEntry, int userId, String movieId){
        libraryEntry.setUserID(userId);
        libraryEntry.setMovieID(movieId);
        return libraryEntryDAO.createLibraryEntry(libraryEntry);
    }

    public List<LibraryEntry> getUserEntriesByCode(String userCode){
        // takes userCode, finds userId, then retrieves all library entries
    }

    public void editLibraryEntry(int userId, String movieId){

    }

    public void deleteLibraryEntry(int userId, String movieId){

    }
}
