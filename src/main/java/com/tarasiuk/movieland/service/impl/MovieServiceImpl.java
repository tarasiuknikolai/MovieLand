package com.tarasiuk.movieland.service.impl;

import com.tarasiuk.movieland.cache.CurrencyRatesCache;
import com.tarasiuk.movieland.dao.MovieDAO;
import com.tarasiuk.movieland.dto.request.AddMovieRequestDTO;
import com.tarasiuk.movieland.dto.request.EditMovieRequestDTO;
import com.tarasiuk.movieland.dto.request.GetMovieRequestDTO;
import com.tarasiuk.movieland.dto.request.SearchMovieRequestDTO;
import com.tarasiuk.movieland.entity.Movie;

import com.tarasiuk.movieland.service.CountryService;
import com.tarasiuk.movieland.service.GenreService;
import com.tarasiuk.movieland.service.MovieService;
import com.tarasiuk.movieland.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

    @Autowired
    private CurrencyRatesCache currencyRatesCache;

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
    public Movie getById(int id, String currency) {
        Movie movie = movieDao.getById(id);
        if (currency != null) {
            movie.setPrice(calcPrice(movie.getPrice(), currencyRatesCache.getCurrencyRateByCharCode(currency).getRate()));
        }
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

    private double calcPrice(double initValue, double rate) {
        int scale = 2;
        BigDecimal bd = new BigDecimal(initValue/rate);
        bd = bd.setScale(scale, BigDecimal.ROUND_HALF_UP);
        return bd.doubleValue();
    }

    @Override
    public List<Movie> getAll(GetMovieRequestDTO getMovieRequestDTO, String currency) {
        List<Movie> movieList = movieDao.getAll(getMovieRequestDTO);

        if (currency != null) {
            for (Movie movie : movieList) {
                movie.setPrice(calcPrice(movie.getPrice(), currencyRatesCache.getCurrencyRateByCharCode(currency).getRate()));
            }
        }

        populateCountry(movieList);
        populateGenre(movieList);
        populateReview(movieList);
        return movieList;
    }

    @Override
    public void addMovieRequest(AddMovieRequestDTO addMovieRequestDTO) {

    }

    @Override
    public void editMovieRequest(EditMovieRequestDTO editMovieRequestDTO) {

    }

    @Override
    public void updateMovieRatingValue(int id) {
        movieDao.updateRatingValue(id);
    }

    @Override
    public void updateMarked2Del(int movieId, int mark) {
        movieDao.updateMarked2Del(movieId, mark);
    }

    @Scheduled(cron = "0 0 0 * * ?")
    public void deleteMarkedFromDB() {
        movieDao.deleteMarkedMoviesFromDB();
    }


}
