package com.tarasiuk.movieland.dao;

import java.util.List;

import com.tarasiuk.movieland.entity.Genre;

public interface GenreDAO {

    List<Genre> getAllForMovie(int movieId);

    List<Genre> getAll();
}
