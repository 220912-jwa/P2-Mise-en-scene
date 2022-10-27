package dev.mis.entities;

public class Movie {
    public String movieID;
    //tt<movieID>, the movie ID comes after the tt
    public String title;
    public float rating; //IMDB or RT?
    public String language;
    public int year;

    public Movie(){}


    public Movie(String movieID, String title, float rating, String language, int year) {
        this.movieID = movieID;
        this.title = title;
        this.rating = rating;
        this.language = language;
        this.year = year;
    }//no user inputs

    public Movie(String title, float rating, String language, int year) {
        this.title = title;
        this.rating = rating;
        this.language = language;
        this.year = year;
    }//for manual generation, no movieID

    public String getMovieID() {
        return movieID;
    }

    public void setMovieID(String movieID) {
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }



    @Override
    public String toString() {
        return "Movie{" +
                "movieID=" + movieID +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                ", language='" + language + '\'' +
                ", releaseYear=" + year +
                '}';
    }
}
