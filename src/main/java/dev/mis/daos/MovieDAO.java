package dev.mis.daos;

import dev.mis.entities.Movie;
import dev.mis.util.ConnectionUtil;

import java.sql.*;

public class MovieDAO {
<<<<<<< HEAD
    public Movie createMovie(){
        // Should include a way to generate an integer id
    }
    public Movie getMovieById(String movieID){}
    //should check DB first, and catch SQL exception by sending movieID prefaced with "tt" to OMDB API
    public boolean updateMovie(Movie movie){}

    public boolean deleteMovie(String movieID){}
=======
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
    public Movie getMovieById(String movieID){
        try(Connection conn = ConnectionUtil.createConnection()){
        String sql = "select * from mis.movies where movie_id=?";
        PreparedStatement ps =conn.prepareStatement(sql);
        ps.setString(1,movieID);
        ResultSet rs =ps.executeQuery();
        if(rs.next()){
            Movie movie = new Movie(
                    rs.getString("movie_id"),
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
            ps.setString(5,movie.getMovieID());
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
>>>>>>> c4b82f308d97c8209e059b6f40a38fa4134eba12
}
