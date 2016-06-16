package com.tarasiuk.movieland.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Review {
    @JsonIgnore
    private int id;
    @JsonIgnore
    private int movieid;
    @JsonIgnore
    private int userid;
    @JsonIgnore
    private Movie movie;
    @JsonIgnore
    private User user;
    private String review;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovieid() {
        return movieid;
    }

    public void setMovieid(int movieid) {
        this.movieid = movieid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", movieid=" + movieid +
                ", userid=" + userid +
                ", movie=" + movie +
                ", user=" + user +
                ", review='" + review + '\'' +
                '}';
    }
}
