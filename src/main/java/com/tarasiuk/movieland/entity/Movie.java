package com.tarasiuk.movieland.entity;

import java.util.List;

public class Movie {
    private int id;
    private String namerus;
    private String nameeng;
    private int yr;
    private List<Country> country;
    private List<Genre> genre;
    private String descr;
    private double rating;
    private double price;
    private List<Review> review;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamerus() {
        return namerus;
    }

    public void setNamerus(String namerus) {
        this.namerus = namerus;
    }

    public String getNameeng() {
        return nameeng;
    }

    public void setNameeng(String nameeng) {
        this.nameeng = nameeng;
    }

    public int getYr() {
        return yr;
    }

    public void setYr(int yr) {
        this.yr = yr;
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

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
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
                ", namerus='" + namerus + '\'' +
                ", nameeng='" + nameeng + '\'' +
                ", yr=" + yr +
                ", country=" + country +
                ", genre=" + genre +
                ", descr='" + descr + '\'' +
                ", rating=" + rating +
                ", price=" + price +
                '}';
    }
}