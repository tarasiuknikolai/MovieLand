package com.tarasiuk.movieland.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tarasiuk.movieland.entity.Movie;

import java.util.List;

public class AddMovieRequestDTO {

    private int id;
    private String nameRus;
    private String nameOrigin;
    private int year;
    @JsonProperty("country")
    private List<Integer> country;
    @JsonProperty("genre")
    private List<Integer> genre;
    private String description;
    private double rating;
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Integer> getCountry() {
        return country;
    }

    public void setCountry(List<Integer> country) {
        this.country = country;
    }

    public List<Integer> getGenre() {
        return genre;
    }

    public void setGenre(List<Integer> genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "AddMovieRequestDTO{" +
                "id=" + id +
                ", nameRus='" + nameRus + '\'' +
                ", nameOrigin='" + nameOrigin + '\'' +
                ", year=" + year +
                ", country=" + country +
                ", genre=" + genre +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                ", price=" + price +
                '}';
    }
}
