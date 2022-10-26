package dev.mis.daos;

import dev.mis.entities.Movie;
import dev.mis.util.ConnectionUtil;

import java.sql.*;

public class MovieDAO {
    public Movie createMovie(Movie movie){
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "insert into mis.movies values (?, ?, ?, ?, ?)";
            PreparedStatement ps =conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,movie.getMovieID());
            //needs to be generated on service layer
            ps.setString(2,movie.getTitle());
            ps.setFloat(3,movie.getRating());
            ps.setString(4,movie.getLanguage());
            ps.setInt(5,movie.getReleaseYear());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                return movie;
            }else{
                return null;
            }

        }
    catch (SQLException e){
            e.printStackTrace();
            return null;

        }
    }
    public Movie getMovieById(int movieID){
        try(Connection conn = ConnectionUtil.createConnection()){
        String sql = "select * from mis.movies where movie_id=?";
        PreparedStatement ps =conn.prepareStatement(sql);
        ps.setInt(1,movieID);
        ResultSet rs =ps.executeQuery();
        if(rs.next()){
            Movie movie = new Movie(
                    rs.getInt("movie_id"),
                    rs.getString("title"),
                    rs.getFloat("IMDB_rating"),
                    rs.getString("original_language"),
                    rs.getInt("release_year")
            );
            return movie;
        }else{
            return null;
        }

    }
    catch (SQLException e){
        e.printStackTrace();
        return null;

    }}
    //should check DB first, and catch SQL exception by sending movieID prefaced with "tt" to OMDB API
    public boolean updateMovie(Movie movie){
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "update mis.movies set title=?, IMDB_rating=?, original_language=?, release_year=? where movie_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,movie.getTitle());
            ps.setFloat(2, movie.getRating());
            ps.setString(3,movie.getLanguage());
            ps.setInt(4,movie.getReleaseYear());
            ps.setInt(5,movie.getMovieID());
            int rowCount = ps.executeUpdate();
            if (rowCount==1){
                return true;
            }else{
                return false;}
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteMovie(int movieID){
        try (Connection connection = ConnectionUtil.createConnection()) {
            String sql = "delete from mis.movies where movie_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, movieID);
            int rowCount = ps.executeUpdate();
            if (rowCount == 1) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public MovieDAO getById(int id) {
        return null;
    }
}
