package com.tarasiuk.movieland.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.tarasiuk.movieland.entity.Country;
import com.tarasiuk.movieland.entity.Genre;
import com.tarasiuk.movieland.entity.Review;
import com.tarasiuk.movieland.utils.JsonCustomReviewSerializer;
import com.tarasiuk.movieland.utils.JsonCustomCountrySerializer;
import com.tarasiuk.movieland.utils.JsonCustomGenreSerializer;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.List;

@JacksonXmlRootElement(localName = "movie")
public class MovieByIdDTO {
    private String nameRus;
    private String nameOrigin;
    private int year;

    @JsonSerialize(using = JsonCustomCountrySerializer.class)
    @JacksonXmlElementWrapper(localName = "countries")
    private List<Country> country;

    @JsonSerialize(using = JsonCustomGenreSerializer.class)
    @JacksonXmlElementWrapper(localName = "genres")
    private List<Genre> genre;
    private String description;

    @JsonSerialize(using = JsonCustomReviewSerializer.class)
    @JacksonXmlElementWrapper(localName = "reviews")
    private List<Review> review;
    private double rating;
    private double price;

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

    public List<Genre> getGenre() {
        return genre;
    }

    public void setGenre(List<Genre> genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Review> getReview() {
        return review;
    }

    public void setReview(List<Review> review) {
        this.review = review;
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
}
