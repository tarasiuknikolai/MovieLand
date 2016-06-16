package com.tarasiuk.movieland.dto;

import java.util.List;
import com.tarasiuk.movieland.entity.Country;
import com.tarasiuk.movieland.entity.Genre;


public class MovieQueryDTO {
    private List<Genre> genre;
    private String nameRus;
    private String nameOrigin;
    private int year;
    private List<Country> country;

    public List<Genre> getGenre() {
        return genre;
    }

    public void setGenre(List<Genre> genre) {
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Country> getCountry() {
        return country;
    }

    public void setCountry(List<Country> country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "MovieQueryDTO{" +
                "genre=" + genre +
                ", nameRus='" + nameRus + '\'' +
                ", nameOrigin='" + nameOrigin + '\'' +
                ", year=" + year +
                ", country=" + country +
                '}';
    }
}
