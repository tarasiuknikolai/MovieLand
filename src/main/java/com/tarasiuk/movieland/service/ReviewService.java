package com.tarasiuk.movieland.service;

import java.util.List;

import com.tarasiuk.movieland.dto.request.AddReviewRequestDTO;
import com.tarasiuk.movieland.dto.request.RateMovieRequestDTO;
import com.tarasiuk.movieland.entity.Review;
import com.tarasiuk.movieland.service.exceptions.RestrictAccessException;


public interface ReviewService {

    List<Review> getAllForMovie(int movieId);

    List<Review> getLimitedForMovie (int movieId, int limitCount);

    void rateMovieRequest(RateMovieRequestDTO rateMovieRequestDTO) throws RestrictAccessException;

    void addReviewRequest(AddReviewRequestDTO addReviewRequestDTO) throws RestrictAccessException;

    void removeReviewRequest(Integer reviewId, Integer userId) throws RestrictAccessException;

}
