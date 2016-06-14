package com.tarasiuk.movieland.entity;

import java.util.List;

public class Movie {
    private int id;
    private String nameRus;
    private String nameOrigin;
    private int year;
    private List<Country> country;
    private List<Genre> genre;
    private String description;
    private double rating;
    private double price;
    private List<Review> review;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameRus() {
        return nameRus;
    }

    public void setNameRus(String namerus) {
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

    public List<Review> getReview() {
        return review;
    }

    public void setReview(List<Review> review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", nameRus='" + nameRus + '\'' +
                ", nameOrigin='" + nameOrigin + '\'' +
                ", year=" + year +
                ", country=" + country +
                ", genre=" + genre +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                ", price=" + price +
                ", review=" + review +
                '}';
    }
}