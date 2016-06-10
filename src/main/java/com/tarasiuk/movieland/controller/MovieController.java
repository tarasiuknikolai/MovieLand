package com.tarasiuk.movieland.controller;

import com.tarasiuk.movieland.entity.Movie;
import com.tarasiuk.movieland.service.MovieService;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/v1/movieland")
public class MovieController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MovieService movieService;

    @RequestMapping("/{movieId}")
    @ResponseBody
    public String getMovieById(@PathVariable int movieId) {
        log.info("Sending request to get movie with id = {}", movieId);
        long startTime = System.currentTimeMillis();
        Movie movie = movieService.getById(movieId);
        Gson gson = new Gson();
        String movieJson = gson.toJson(movie);
        log.info("City {} is received. It took {} ms", movieJson, System.currentTimeMillis() - startTime);
        return movieJson;
    }
}
