package com.tarasiuk.movieland.dao;

import com.tarasiuk.movieland.dto.request.RatingRequestDTO;
import com.tarasiuk.movieland.entity.Rating;

public interface RatingDAO {

    void addRating(RatingRequestDTO ratingRequestDTO);

    void deleteRating(RatingRequestDTO ratingRequestDTO);

    Rating getRatingById(int ratingId);

    Rating getRatingByMovieId(int movieId);

    Rating getRatingByUserId(int userId);
}
