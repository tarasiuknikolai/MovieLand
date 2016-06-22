package com.tarasiuk.movieland.service;

import com.tarasiuk.movieland.dto.request.MovieOrganizeOutputDTO;
import com.tarasiuk.movieland.dto.request.MovieQueryDTO;
import com.tarasiuk.movieland.entity.Movie;
import java.util.List;

public interface MovieService {

    List<Movie> getAll(MovieQueryDTO queryQuestion);

    List<Movie> getAll(MovieOrganizeOutputDTO movieOrganizeOutputDTO);

    Movie getById(int id);

}
