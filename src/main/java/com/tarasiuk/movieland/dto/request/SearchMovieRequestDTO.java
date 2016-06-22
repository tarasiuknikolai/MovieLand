package com.tarasiuk.movieland.dto.request;

public class SearchMovieRequestDTO {
    private String genre;
    private String nameRus;
    private String nameOrigin;
    private Integer year;
    private String country;

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getNameRus() {
        return nameRus;
    }

    public void setNameRus(String nameRus) {
        this.nameRus = nameRus;
    }

    public String getNameOrigin() {
        return nameOrigin;
    }

    public void setNameOrigin(String nameOrigin) {
        this.nameOrigin = nameOrigin;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "SearchMovieRequestDTO{" +
                "genre='" + genre + '\'' +
                ", nameRus='" + nameRus + '\'' +
                ", nameOrigin='" + nameOrigin + '\'' +
                ", year=" + year +
                ", country='" + country + '\'' +
                '}';
    }
}