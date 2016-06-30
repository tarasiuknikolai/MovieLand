package com.tarasiuk.movieland.service;

import com.tarasiuk.movieland.dto.request.RatingRequestDTO;
import com.tarasiuk.movieland.entity.Rating;

public interface RatingService {

    void putRating(RatingRequestDTO ratingRequestDTO);

    Rating getRatingById(int ratingId);

    Rating getRatingByMovieId(int movieId);

    Rating getRatingByUserId(int userId);

}
