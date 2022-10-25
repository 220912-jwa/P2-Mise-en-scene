package dev.mis.daos;

import dev.mis.entities.Movie;
import dev.mis.entities.LibraryEntry;
import dev.mis.entities.User;

import java.util.List;

public class LibraryEntryDAO {
    public LibraryEntry createLibraryEntry(User user, Movie movie){}

    public boolean updateLibraryEntry(User user, Movie movie){}

    public boolean deleteLibraryEntry(User user, Movie movie){}

    public List<LibraryEntry> getUserLibraryEntries(User user, Movie movie){}
}
