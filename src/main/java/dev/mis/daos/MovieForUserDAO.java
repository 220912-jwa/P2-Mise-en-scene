package dev.mis.daos;

import dev.mis.entities.Movie;
import dev.mis.entities.MovieForUser;
import dev.mis.entities.User;

import java.util.List;

public class MovieForUserDAO {
    public MovieForUser createLibraryEntry(User user, Movie movie){}

    public boolean updateLibraryEntry(User user, Movie movie){}

    public boolean deleteLibraryEntry(User user, Movie movie){}

    public List<MovieForUser> getAllLibraryEntries(User user, Movie movie){}
}
