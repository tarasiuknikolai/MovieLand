package com.tarasiuk.movieland.service;

import com.tarasiuk.movieland.dto.request.RatingRequestDTO;
import com.tarasiuk.movieland.entity.Rating;

import java.util.List;

public interface RatingService {

    Rating getRatingById(int ratingId);

    List<Rating> getRatingByMovieId(int movieId);

    List<Rating> getRatingByUserId(int userId);

    void addRating(RatingRequestDTO ratingRequestDTO);

    void deleteRating(RatingRequestDTO ratingRequestDTO);

}
