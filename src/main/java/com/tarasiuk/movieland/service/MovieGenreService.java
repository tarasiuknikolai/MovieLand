package com.tarasiuk.movieland.service;

import com.tarasiuk.movieland.entity.MovieGenre;

import java.util.List;

public interface MovieGenreService {

    List<MovieGenre> getAllForMovie(int movieId);
}
