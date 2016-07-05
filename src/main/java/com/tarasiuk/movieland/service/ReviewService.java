package com.tarasiuk.movieland.service;

import java.util.List;

import com.tarasiuk.movieland.dto.request.AddReviewRequestDTO;
import com.tarasiuk.movieland.entity.Review;


public interface ReviewService {

    List<Review> getAllForMovie(int movieId);

    List<Review> getLimitedForMovie (int movieId, int limitCount);

    void addReview(AddReviewRequestDTO addReviewRequestDTO);

    void deleteReview(int reviewId);

}
