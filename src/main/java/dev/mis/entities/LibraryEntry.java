package dev.mis.entities;

public class LibraryEntry {
    public int userID;
    public String movieID;
    public String userComments;
    public float userRating;
    public boolean isFavorite;
    public boolean hasWatched;

    // fields for parity with the movietable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String title;
    public float rating; //IMDB or RT?
    public String language;
    public int releaseYear;

    public LibraryEntry(){}

    public LibraryEntry(int userID, String movieID, String userComments, float userRating, boolean isFavorite,
                        boolean hasWatched, String title, float rating, String language, int releaseYear) {
        this.userID = userID;
        this.movieID = movieID;
        this.userComments = userComments;
        this.userRating = userRating;
        this.isFavorite = isFavorite;
        this.hasWatched = hasWatched;
        this.title = title;
        this.rating = rating;
        this.language = language;
        this.releaseYear = releaseYear;
    }

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
