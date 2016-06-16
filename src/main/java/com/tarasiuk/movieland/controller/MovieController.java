package com.tarasiuk.movieland.controller;

import com.tarasiuk.movieland.dto.MovieAllDTO;
import com.tarasiuk.movieland.dto.MovieByIdDTO;
import com.tarasiuk.movieland.dto.MovieQueryDTO;
import com.tarasiuk.movieland.entity.Movie;
import com.tarasiuk.movieland.service.MovieService;

import com.tarasiuk.movieland.utils.JsonCustomConverter;
import com.tarasiuk.movieland.utils.OrderClause;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public MovieByIdDTO getMovieById(@PathVariable int movieId) {
        log.info("Sending request to get movie with id = {}", movieId);
        long startTime = System.currentTimeMillis();
        ModelMapper modelMapper = new ModelMapper();
        MovieByIdDTO movieByIdDTO = modelMapper.map(movieService.getById(movieId), MovieByIdDTO.class);
        log.info("Movie with ID {} is received. It took {} ms", movieId, System.currentTimeMillis() - startTime);
        return movieByIdDTO;
    }

    private String formingOrderClause(String clause, String field) {
        if (clause != null && clause.toUpperCase().equals(OrderClause.ASC.getOrderClause()))
            return field + OrderClause.ASC.getOrderClause();
        else if (clause != null && clause.toUpperCase().equals(OrderClause.DESC.getOrderClause()))
            return field + OrderClause.DESC.getOrderClause();
        else return "";
    }

    @RequestMapping(value = "/movies", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<MovieAllDTO> getAll(@RequestParam(value = "rating", required = false) String ratingOrder
            , @RequestParam(value = "price", required = false) String priceOrder) {

        log.info("Sending request to get all movies");
        long startTime = System.currentTimeMillis();
        StringBuilder orderClause = new StringBuilder(" ORDER BY 'a' ");
        if (ratingOrder != null || priceOrder != null) {
            orderClause.append(formingOrderClause(ratingOrder, ", rating "));
            orderClause.append(formingOrderClause(priceOrder, ", price "));
        } else orderClause.delete(0, orderClause.length());

        List<Movie> listMovie = movieService.getAll(orderClause.toString());

        List<MovieAllDTO> movieListDTO = new ArrayList();
        ModelMapper modelMapper = new ModelMapper();
        for (Movie movie : listMovie) {
            MovieAllDTO movieAllDTO = modelMapper.map(movie, MovieAllDTO.class);
            movieListDTO.add(movieAllDTO);
        }

        log.info("All movies is received. It took {} ms", System.currentTimeMillis() - startTime);
        return movieListDTO;
    }

    @RequestMapping(value = "/search", consumes = "application/json;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public List<MovieAllDTO> gtMovieById(@RequestBody MovieQueryDTO movieQueryDTO) {
        System.out.println(movieQueryDTO);
        //log.info("Sending request to get movie with id = {}", movieId);
        long startTime = System.currentTimeMillis();
        //log.info("Movie with ID {} is received. It took {} ms", movieId , System.currentTimeMillis() - startTime);
        //List<Movie> listMovieQuery = movieService.getQueried();
        List<MovieAllDTO> movieListQueryDTO = new ArrayList<>();
        return movieListQueryDTO;
    }
}