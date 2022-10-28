package dev.mis.services;

import dev.mis.daos.LibraryEntryDAO;
import dev.mis.daos.MovieDAO;
import dev.mis.daos.UserDAO;
import dev.mis.entities.LibraryEntry;

import java.util.ArrayList;
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

    public LibraryEntry createLibraryEntry(LibraryEntry libraryEntry){
        return libraryEntryDAO.createLibraryEntry(libraryEntry);
    }
    public List<LibraryEntry> getUserEntriesById(int userID){
        List<LibraryEntry> entryList = libraryEntryDAO.getUserEntriesById(userID);
        return entryList;
    }

    public List<LibraryEntry> getUserEntriesByCode(String userCode){


        List<LibraryEntry> entryList = libraryEntryDAO.getUserEntriesByCode(userCode);
        return entryList;

    }

    public void editLibraryEntry(LibraryEntry libraryEntry){

    }

    public void deleteLibraryEntry(int userId, String movieId){

    }
}
