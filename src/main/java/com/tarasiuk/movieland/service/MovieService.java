package com.tarasiuk.movieland.service;

import com.tarasiuk.movieland.dto.request.AddMovieRequestDTO;
import com.tarasiuk.movieland.dto.request.EditMovieRequestDTO;
import com.tarasiuk.movieland.dto.request.GetMovieRequestDTO;
import com.tarasiuk.movieland.dto.request.SearchMovieRequestDTO;
import com.tarasiuk.movieland.entity.Movie;
import com.tarasiuk.movieland.service.exceptions.RestrictAccessException;

import java.util.List;

public interface MovieService {

    List<Movie> getAll(SearchMovieRequestDTO queryQuestion);

    List<Movie> getAll(GetMovieRequestDTO getMovieRequestDTO);

    Movie getById(int id, String token);

    void addMovieRequest(AddMovieRequestDTO addMovieRequestDTO) throws RestrictAccessException;

    void editMovieRequest(EditMovieRequestDTO editMovieRequestDTO) throws RestrictAccessException;

    void markMovieForRemovingRequest(int movieID) throws RestrictAccessException;

    void unmarkMovieForRemovingRequest(int movieID) throws RestrictAccessException;

    void updateMovieRatingValue(int id) throws RestrictAccessException;

}
