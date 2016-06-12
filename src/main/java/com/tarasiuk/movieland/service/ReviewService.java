package com.tarasiuk.movieland.service;

import java.util.List;
import com.tarasiuk.movieland.entity.Review;


public interface ReviewService {

    List<Review> getAllForMovie(int movieId);

    List<Review> getLimitedForMovie (int movieId, int limitCnt);

}
