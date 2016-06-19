package com.tarasiuk.movieland.dao;

import com.tarasiuk.movieland.entity.MovieGenre;

import java.util.List;

public interface MovieGenreDAO {

    List<MovieGenre> getAllForMovie(int movieId);

}
