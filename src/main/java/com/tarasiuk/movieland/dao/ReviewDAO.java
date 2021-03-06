package com.tarasiuk.movieland.dao;

import java.util.List;
import com.tarasiuk.movieland.entity.Review;

public interface ReviewDAO {

    List<Review> getAllForMovie (int movieId);

    List<Review> getLimitedForMovie (int movieId, int limitCount);

    Review getReviewById (int reviewId);

    void addReview (Review review);

    void deleteReview (Integer reviewId);
}
