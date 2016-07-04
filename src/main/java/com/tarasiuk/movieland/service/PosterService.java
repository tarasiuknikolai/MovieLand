package com.tarasiuk.movieland.service;

import com.tarasiuk.movieland.entity.Poster;

public interface PosterService {

    Poster getPosterByMovieId(int movieId);

}
