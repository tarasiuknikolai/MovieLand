package com.tarasiuk.movieland.controller;

import com.tarasiuk.movieland.dto.MovieAllDTO;
import com.tarasiuk.movieland.dto.MovieByIdDTO;
import com.tarasiuk.movieland.dto.MoviesListDTO;
import com.tarasiuk.movieland.dto.request.GetMovieRequestDTO;
import com.tarasiuk.movieland.dto.request.SearchMovieRequestDTO;
import com.tarasiuk.movieland.entity.Movie;
import com.tarasiuk.movieland.service.MovieService;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/movie/{movieId}", method = RequestMethod.GET)
    @ResponseBody
    public MovieByIdDTO getMovieById(@PathVariable int movieId) {
        log.info("Sending request to get movie with id = {}", movieId);
        long startTime = System.currentTimeMillis();
        ModelMapper modelMapper = new ModelMapper();
        MovieByIdDTO movieByIdDTO = modelMapper.map(movieService.getById(movieId), MovieByIdDTO.class);
        log.info("Movie with ID {} is received. It took {} ms", movieId, System.currentTimeMillis() - startTime);
        return movieByIdDTO;
    }

    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    @ResponseBody
    public MoviesListDTO getAll(@RequestParam(value = "rating", required = false) String ratingOrder
            , @RequestParam(value = "price", required = false) String priceOrder
            , @RequestParam(value = "page", required = false) Integer pageNumber) {

        log.info("Sending request to get all movies");
        long startTime = System.currentTimeMillis();

        GetMovieRequestDTO getMovieRequestDTO = createGetMovieRequestDTO(ratingOrder, priceOrder, pageNumber);

        List<Movie> listMovie = movieService.getAll(getMovieRequestDTO);

        List<MovieAllDTO> movieListDTO = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for (Movie movie : listMovie) {
            MovieAllDTO movieAllDTO = modelMapper.map(movie, MovieAllDTO.class);
            movieListDTO.add(movieAllDTO);
        }
        MoviesListDTO moviesListDTO = new MoviesListDTO();
        moviesListDTO.setMovies(movieListDTO);

        log.info("All movies is received. It took {} ms", System.currentTimeMillis() - startTime);
        return moviesListDTO;
    }

    private GetMovieRequestDTO createGetMovieRequestDTO(String ratingOrder, String priceOrder, Integer pageNumber) {
        GetMovieRequestDTO getMovieRequestDTO = new GetMovieRequestDTO();
        getMovieRequestDTO.setRatingOrder(ratingOrder);
        getMovieRequestDTO.setPriceOrder(priceOrder);
        getMovieRequestDTO.setPageNumber(pageNumber);
        return getMovieRequestDTO;
    }

    @RequestMapping(value = "/movie/search", method = RequestMethod.POST)
    @ResponseBody
    public List<MovieAllDTO> search(@RequestBody SearchMovieRequestDTO searchMovieRequestDTO) {
        List<Movie> listMovie = movieService.getAll(searchMovieRequestDTO);
        List<MovieAllDTO> movieListDTO = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for (Movie movie : listMovie) {
            MovieAllDTO movieAllDTO = modelMapper.map(movie, MovieAllDTO.class);
            movieListDTO.add(movieAllDTO);
        }
        return movieListDTO;
    }

}