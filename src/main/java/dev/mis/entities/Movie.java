package dev.mis.entities;

public class Movie {
    public int movieID;
    public String title;
    public float rating; //IMDB or RT?
    public String language;
    public int releaseYear;
    public String userComments;
    public float userRating;
    public boolean isFavorite;
    public boolean hasWatched;

    public Movie(){}

    public Movie(int movieID, String title, float rating, String language, int releaseYear, String userComments, float userRating, boolean isFavorite, boolean hasWatched) {
        this.movieID = movieID;
        this.title = title;
        this.rating = rating;
        this.language = language;
        this.releaseYear = releaseYear;
        this.userComments = userComments;
        this.userRating = userRating;
        this.isFavorite = isFavorite;
        this.hasWatched = hasWatched;
    }

    public Movie(int movieID, String title, float rating, String language, int releaseYear) {
        this.movieID = movieID;
        this.title = title;
        this.rating = rating;
        this.language = language;
        this.releaseYear = releaseYear;
    }//no user inputs

    public Movie(String title, float rating, String language, int releaseYear, String userComments, float userRating, boolean isFavorite, boolean hasWatched) {
        this.title = title;
        this.rating = rating;
        this.language = language;
        this.releaseYear = releaseYear;
        this.userComments = userComments;
        this.userRating = userRating;
        this.isFavorite = isFavorite;
        this.hasWatched = hasWatched;
    }//no movieID, for fetching later w/ OMDB API

    public Movie(String title, float rating, String language, int releaseYear) {
        this.title = title;
        this.rating = rating;
        this.language = language;
        this.releaseYear = releaseYear;
    }//for manual generation, no movieID or user input

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

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
        return "Movie{" +
                "movieID=" + movieID +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                ", language='" + language + '\'' +
                ", releaseYear=" + releaseYear +
                ", userComments='" + userComments + '\'' +
                ", userRating=" + userRating +
                ", isFavorite=" + isFavorite +
                ", hasWatched=" + hasWatched +
                '}';
    }
}
