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

    List<Movie> getAll(GetMovieRequestDTO getMovieRequestDTO, String currency);

    Movie getById(int id, String currency);

    void addMovieRequest(AddMovieRequestDTO addMovieRequestDTO) throws RestrictAccessException;

    void updateMovieRatingValue(int id) throws RestrictAccessException;

    void updateMarked2Del(int movieId, int mark);

}
