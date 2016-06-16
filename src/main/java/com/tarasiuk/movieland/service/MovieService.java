package com.tarasiuk.movieland.service;

import com.tarasiuk.movieland.entity.Movie;
import java.util.List;

public interface MovieService {

    List<Movie> getAll(String orderClause);

    List<Movie> getQueried();

    Movie getById(int id);

}
