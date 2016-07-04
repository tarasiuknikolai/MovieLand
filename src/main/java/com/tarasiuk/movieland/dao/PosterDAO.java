package com.tarasiuk.movieland.dao;

import com.tarasiuk.movieland.entity.Poster;

public interface PosterDAO {

    Poster getPosterByMovieId(int movieId);

}
