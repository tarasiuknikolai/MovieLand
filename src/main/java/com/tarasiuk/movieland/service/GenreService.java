package com.tarasiuk.movieland.service;

import java.util.List;
import com.tarasiuk.movieland.entity.Genre;

public interface GenreService {

    List<Genre> getAllForMovie(int movieId);

    List<Genre> getAll();

    Genre getById (int genreId);

}
