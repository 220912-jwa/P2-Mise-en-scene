package dev.mis.entities;

public class MovieForUser {
    public int userID;
    public int movieID;
    public String userComments;
    public float userRating;
    public boolean isFavorite;
    public boolean hasWatched;

    public MovieForUser(){}

    public MovieForUser(int userID, int movieID, String userComments, float userRating, boolean isFavorite, boolean hasWatched) {
        this.userID = userID;
        this.movieID = movieID;
        this.userComments = userComments;
        this.userRating = userRating;
        this.isFavorite = isFavorite;
        this.hasWatched = hasWatched;
    }//should be the only constructor we need

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public String getUserComments() {
        return userComments;
    }

    public void setUserComments(String userComments) {
        this.userComments = userComments;
    }

    public float getUserRating() {
        return userRating;
    }

    public void setUserRating(float userRating) {
        this.userRating = userRating;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public boolean isHasWatched() {
        return hasWatched;
    }

    public void setHasWatched(boolean hasWatched) {
        this.hasWatched = hasWatched;
    }

    @Override
    public String toString() {
        return "MovieForUser{" +
                "userID=" + userID +
                ", movieID=" + movieID +
                ", userComments='" + userComments + '\'' +
                ", userRating=" + userRating +
                ", isFavorite=" + isFavorite +
                ", hasWatched=" + hasWatched +
                '}';
    }
}
