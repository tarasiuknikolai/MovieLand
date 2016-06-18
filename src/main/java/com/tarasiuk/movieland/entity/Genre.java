package com.tarasiuk.movieland.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Genre {
    @JsonIgnore
    private int id;
    @JsonProperty
    private String genre;

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getGenre() {return genre;}

    public void setGenre(String genre) {this.genre = genre;}

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", genre='" + genre + '\'' +
                '}';
    }
}
