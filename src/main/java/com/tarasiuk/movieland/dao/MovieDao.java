package com.tarasiuk.movieland.dao;

import java.util.List;
import com.tarasiuk.movieland.entity.Movie;

public interface MovieDao {

    List<Movie> getAll();

    Movie getById(int id);

}
