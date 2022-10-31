package dev.mis.daos;

import dev.mis.entities.Movie;
import dev.mis.entities.LibraryEntry;
import dev.mis.entities.User;
import dev.mis.util.ConnectionUtil;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class LibraryEntryDAO {


    public LibraryEntry createLibraryEntry(LibraryEntry libraryEntry){
        try(Connection conn = ConnectionUtil.createConnection()) {
            String sql = "insert into mis.user_library values (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, libraryEntry.getUserID());
            ps.setString(2, libraryEntry.getMovieID());
            ps.setString(3, libraryEntry.getUserComments());
            ps.setFloat(4, libraryEntry.getUserRating());
            ps.setBoolean(5, libraryEntry.isFavorite());
            ps.setBoolean(6, libraryEntry.isHasWatched());


            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return libraryEntry;
            }

        }
        catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public boolean updateLibraryEntry(LibraryEntry libraryEntry){
        try(Connection conn = ConnectionUtil.createConnection()) {
            String sql = "update mis.user_library set user_comments = ?, user_rating = ?, is_favorite = ?, has_watched = ? where movie_id = ? and user_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, libraryEntry.getUserComments());
            ps.setFloat(2, libraryEntry.getUserRating());
            ps.setBoolean(3, libraryEntry.isFavorite());
            ps.setBoolean(4, libraryEntry.isHasWatched());
            ps.setString(5, libraryEntry.getMovieID());
            ps.setInt(6, libraryEntry.getUserID());


            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    public boolean deleteLibraryEntry(LibraryEntry libraryEntry){
        try(Connection conn = ConnectionUtil.createConnection()) {
            String sql = "delete from mis.user_library where user_id = ? and movie_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, libraryEntry.getUserID());
            ps.setString(2, libraryEntry.getMovieID());
            int complete = ps.executeUpdate();


            if(complete == 1){
                return true;
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        return false;
    }


    public List<LibraryEntry> getUserEntriesByCode(String userCode){
        try(Connection conn = ConnectionUtil.createConnection()) {
            String sql = "select * from mis.user_library left join mis.movies on mis.user_library.movie_id = mis.movies.movie_id left join mis.users on mis.user_library.user_id=mis.users.user_id where mis.users.user_code = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userCode);
            ResultSet rsLibrary = ps.executeQuery();
            List<LibraryEntry> libraryEntryList = new ArrayList<LibraryEntry>();

            while(rsLibrary.next()){
                LibraryEntry lb = new LibraryEntry(
                        rsLibrary.getInt("user_id"),
                        rsLibrary.getString("movie_id"),
                        rsLibrary.getString("user_comments"),
                        rsLibrary.getFloat("user_rating"),
                        rsLibrary.getBoolean("is_favorite"),
                        rsLibrary.getBoolean("has_watched"),
                        rsLibrary.getString("title"),
                        rsLibrary.getFloat("IMDB_rating"),
                        rsLibrary.getString("original_language"),
                        rsLibrary.getInt("release_ear")
                );

                libraryEntryList.add(lb);
            }

            return libraryEntryList;
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public List<LibraryEntry> getUserEntriesById(int userId){
        try(Connection conn = ConnectionUtil.createConnection()) {
        String sql = "select * from mis.user_library left join mis.movies on mis.user_library.movie_id = mis.movies.movie_id where mis.user_library.user_id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, userId);
        ResultSet rsLibrary = ps.executeQuery();

        ArrayList<LibraryEntry> libraryEntryList = new ArrayList<LibraryEntry>();

        while(rsLibrary.next()){
            LibraryEntry lb = new LibraryEntry(
                    rsLibrary.getInt("user_id"),
                    rsLibrary.getString("movie_id"),
                    rsLibrary.getString("user_comments"),
                    rsLibrary.getFloat("user_rating"),
                    rsLibrary.getBoolean("is_favorite"),
                    rsLibrary.getBoolean("has_watched"),
                    rsLibrary.getString("title"),
                    rsLibrary.getFloat("imdb_rating"),
                    rsLibrary.getString("original_language"),
                    rsLibrary.getInt("release_year")
            );

            libraryEntryList.add(lb);
        }

        return libraryEntryList;
    }
        catch(SQLException e){
        e.printStackTrace();
    }
        return null;
    }
}
