package com.tarasiuk.movieland.service.impl;

import com.tarasiuk.movieland.dao.MovieDAO;
import com.tarasiuk.movieland.dto.request.GetMovieRequestDTO;
import com.tarasiuk.movieland.dto.request.SearchMovieRequestDTO;
import com.tarasiuk.movieland.entity.Movie;
import com.tarasiuk.movieland.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieDAO movieDao;

    @Autowired
    private CountryService countryService;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private GenreService genreService;

    @Value("${sql.review.limit:2}")
    private int limitCount;

    private void populateCountry(Movie movie) {
        movie.setCountry(countryService.getAllForMovie(movie.getId()));
    }

    private void populateCountry(List<Movie> movieList) {
        for (Movie movie : movieList) {
            populateCountry(movie);
        }
    }

    private void populateGenre(Movie movie) {
        movie.setGenre(genreService.getAllForMovie(movie.getId()));
    }

    private void populateGenre(List<Movie> movieList) {
        for (Movie movie : movieList) {
            populateGenre(movie);
        }
    }

    private void populateReview(Movie movie) {
        movie.setReview(reviewService.getLimitedForMovie(movie.getId(), limitCount));
    }

    private void populateReview(List<Movie> movieList) {
        for (Movie movie : movieList) {
            populateReview(movie);
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
    public List<Movie> getAll(SearchMovieRequestDTO queryQuestion) {
        List<Movie> movieList = movieDao.getAll(queryQuestion);
        populateCountry(movieList);
        populateGenre(movieList);
        populateReview(movieList);
        return movieList;
    }

    @Override
    public List<Movie> getAll(GetMovieRequestDTO getMovieRequestDTO) {
        List<Movie> movieList = movieDao.getAll(getMovieRequestDTO);
        populateCountry(movieList);
        populateGenre(movieList);
        populateReview(movieList);
        return movieList;
    }
}