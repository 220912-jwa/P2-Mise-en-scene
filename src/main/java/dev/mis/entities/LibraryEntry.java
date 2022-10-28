package dev.mis.entities;

public class LibraryEntry {
    public int userID;
    public String movieID;
    public String userComments;
    public float userRating;
    public boolean isFavorite;
    public boolean hasWatched;

    public LibraryEntry(){}

    public LibraryEntry(int userID, String movieID, String userComments, float userRating, boolean isFavorite, boolean hasWatched) {
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

    public String getMovieID() {
        return movieID;
    }

    public void setMovieID(String movieID) {
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
