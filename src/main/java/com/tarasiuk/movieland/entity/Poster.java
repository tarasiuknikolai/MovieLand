package com.tarasiuk.movieland.entity;

public class Poster {
    private int id;
    private int movieId;
    private byte[] poster;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public byte[] getPoster() {
        return poster;
    }

    public void setPoster(byte[] poster) {
        this.poster = poster;
    }

    @Override
    public String toString() {
        return "Poster{" +
                "id=" + id +
                ", movieId=" + movieId +
                '}';
    }
}
