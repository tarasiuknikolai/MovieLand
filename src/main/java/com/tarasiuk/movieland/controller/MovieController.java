package com.tarasiuk.movieland.controller;

import com.tarasiuk.movieland.entity.Movie;
import com.tarasiuk.movieland.service.MovieService;

import com.google.gson.Gson;
import com.tarasiuk.movieland.utils.JsonCustomConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/v1")
public class MovieController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MovieService movieService;

    @Autowired
    private JsonCustomConverter jsonCustomConverter;

    @RequestMapping(value = "/movie/{movieId}", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getMovieById(@PathVariable int movieId) {
        log.info("Sending request to get movie with id = {}", movieId);
        long startTime = System.currentTimeMillis();
        Movie movie = movieService.getById(movieId);
        String movieJson = jsonCustomConverter.movieInfoByIdToJson(movie);
        log.info("Movie {} is received. It took {} ms", movieJson, System.currentTimeMillis() - startTime);
        return movieJson;
    }


    @RequestMapping(value = "/movies", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getAll() {
        log.info("Sending request to get all movies");
        long startTime = System.currentTimeMillis();
        List<Movie> listMovies =  movieService.getAll();
        String movieJson = jsonCustomConverter.allMovieToJson(listMovies);
        log.info("All movies is received. It took {} ms", System.currentTimeMillis() - startTime);
        return movieJson;
    }


}
