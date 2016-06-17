package com.tarasiuk.movieland.dto;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tarasiuk.movieland.entity.Genre;
import com.tarasiuk.movieland.utils.JsonCustomGenreSerializer;


public class MovieAllDTO {
    private String nameRus;
    private String nameOrigin;
    private int year;
    private double rating;

    @JsonSerialize(using = JsonCustomGenreSerializer.class)
    private List<Genre> genre;

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

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public List<Genre> getGenre() {
        return genre;
    }

    public void setGenre(List<Genre> genre) {
        this.genre = genre;
    }
}
