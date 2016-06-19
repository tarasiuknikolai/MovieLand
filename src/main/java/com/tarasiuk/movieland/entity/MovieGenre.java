package com.tarasiuk.movieland.entity;

public class MovieGenre {
    private int id;
    private int movieId;
    private int genreId;

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

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    @Override
    public String toString() {
        return "MovieGenre{" +
                "id=" + id +
                ", movieId=" + movieId +
                ", genreId=" + genreId +
                '}';
    }
}
