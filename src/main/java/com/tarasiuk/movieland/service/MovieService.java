package com.tarasiuk.movieland.service;

import com.tarasiuk.movieland.dto.request.GetMovieRequestDTO;
import com.tarasiuk.movieland.dto.request.SearchMovieRequestDTO;
import com.tarasiuk.movieland.entity.Movie;
import java.util.List;

public interface MovieService {

    List<Movie> getAll(SearchMovieRequestDTO queryQuestion);

    List<Movie> getAll(GetMovieRequestDTO getMovieRequestDTO);

    Movie getById(int id);

}
