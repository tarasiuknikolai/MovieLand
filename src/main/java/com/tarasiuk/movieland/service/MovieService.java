package com.tarasiuk.movieland.service;

import com.tarasiuk.movieland.entity.Movie;
import java.util.List;

public interface MovieService {

    List<Movie> getAll();

    Movie getById(int id);

    void populateCountry(Movie movie);

    void populateCountry(List<Movie> movieList);

    void populateGenre(Movie movie);

    void populateGenre(List<Movie> movieList);

    void populateReview(Movie movie);

    void populateReview(List<Movie> movieList);
}
