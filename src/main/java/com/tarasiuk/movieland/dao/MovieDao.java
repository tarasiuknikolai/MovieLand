package com.tarasiuk.movieland.dao;

import java.util.List;
import com.tarasiuk.movieland.entity.Movie;

public interface MovieDAO {

    List<Movie> getAll();

    Movie getById(int id);

}
