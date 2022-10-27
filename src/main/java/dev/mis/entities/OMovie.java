package dev.mis.entities;

public class OMovie {

private String imdbID;
private String Title;
private int Year;

public OMovie(){}

public OMovie(String imdbID, String Title, int Year){
    this.imdbID = imdbID;
    this.Title = Title;
    this.Year = Year;
}

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        this.Year = year;
    }

    @Override
    public String toString() {
        return "OMovie{" +
                "imdbID='" + imdbID + '\'' +
                ", Title='" + Title + '\'' +
                ", Year=" + Year +
                '}';
    }
}
