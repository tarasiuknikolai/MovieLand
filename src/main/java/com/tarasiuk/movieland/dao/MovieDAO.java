package com.tarasiuk.movieland.dao;

import java.util.List;

import com.tarasiuk.movieland.dto.request.GetMovieRequestDTO;
import com.tarasiuk.movieland.dto.request.SearchMovieRequestDTO;
import com.tarasiuk.movieland.entity.Movie;

public interface MovieDAO {

    List<Movie> getAll(SearchMovieRequestDTO queryQuestion);

    List<Movie> getAll(GetMovieRequestDTO getMovieRequestDTO);

    Movie getById(int id);

}
