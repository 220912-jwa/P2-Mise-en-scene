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
    public Movie getMovieById(int movieID){}
    //should check DB first, and catch SQL exception by sending movieID prefaced with "tt" to OMDB API
    public boolean updateMovie(Movie movie){}

    public boolean deleteMovie(int movieID){}
}
