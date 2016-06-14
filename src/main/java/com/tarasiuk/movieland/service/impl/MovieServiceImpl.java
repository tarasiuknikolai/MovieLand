package com.tarasiuk.movieland.service.impl;

import com.tarasiuk.movieland.dao.MovieDAO;
import com.tarasiuk.movieland.entity.Movie;
import com.tarasiuk.movieland.service.CountryService;
import com.tarasiuk.movieland.service.GenreService;
import com.tarasiuk.movieland.service.MovieService;

import com.tarasiuk.movieland.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieDAO movieDao;

    @Autowired
    private CountryService countryService;

    @Autowired
    private GenreService genreService;

    @Autowired
    private ReviewService reviewService;

    private void populateCountry(Movie movie) {
        movie.setCountry(countryService.getAllForMovie(movie.getId()));
    }

    private void populateCountry(List<Movie> movieList) {
        for (Movie m: movieList) {
            populateCountry(m);
        }
    }

    private void populateGenre(Movie movie) {
        movie.setGenre(genreService.getAllForMovie(movie.getId()));
    }

    private void populateGenre(List<Movie> movieList) {
        for (Movie m: movieList) {
            populateGenre(m);
        }
    }

    private void populateReview(Movie movie) {
        movie.setReview(reviewService.getLimitedForMovie(movie.getId(), 2));
    }

    private void populateReview(List<Movie> movieList) {
        for (Movie m: movieList) {
            populateReview(m);
        }
    }

    @Override
    public Movie getById(int id) {
        Movie movie = movieDao.getById(id);
        populateCountry(movie);
        populateGenre(movie);
        populateReview(movie);
        return movie;
    }

    @Override
    public List<Movie> getAll() {
        List<Movie> movieList = movieDao.getAll();
        populateCountry(movieList);
        populateGenre(movieList);
        populateReview(movieList);
        return movieList;
    }
}
