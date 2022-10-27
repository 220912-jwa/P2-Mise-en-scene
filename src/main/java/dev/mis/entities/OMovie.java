package dev.mis.entities;

public class OMovie {

private String oMovieID;
private String oMovieTitle;
private int oMovieReleaseYear;

public OMovie(){}

public OMovie(String oMovieID, String oMovieTitle, int oMovieReleaseYear){
    this.oMovieID = oMovieID;
    this.oMovieTitle = oMovieTitle;
    this.oMovieReleaseYear = oMovieReleaseYear;
}

    public String getoMovieID() {
        return oMovieID;
    }

    public void setoMovieID(String oMovieID) {
        this.oMovieID = oMovieID;
    }

    public String getoMovieTitle() {
        return oMovieTitle;
    }

    public void setoMovieTitle(String oMovieTitle) {
        this.oMovieTitle = oMovieTitle;
    }

    public int getoMovieReleaseYear() {
        return oMovieReleaseYear;
    }

    public void setoMovieReleaseYear(int oMovieReleaseYear) {
        this.oMovieReleaseYear = oMovieReleaseYear;
    }

    @Override
    public String toString() {
        return "OMovie{" +
                "oMovieID='" + oMovieID + '\'' +
                ", oMovieTitle='" + oMovieTitle + '\'' +
                ", oMovieReleaseYear=" + oMovieReleaseYear +
                '}';
    }
}
