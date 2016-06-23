package com.tarasiuk.movieland.service.impl;

import com.tarasiuk.movieland.dao.ReviewDAO;
import com.tarasiuk.movieland.dto.request.AddReviewRequestDTO;
import com.tarasiuk.movieland.dto.request.RateMovieRequestDTO;
import com.tarasiuk.movieland.entity.Review;
import com.tarasiuk.movieland.service.ReviewService;
import com.tarasiuk.movieland.service.exceptions.RestrictAccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    ReviewDAO reviewDao;

    @Override
    public List<Review> getAllForMovie(int movieId) {
        return reviewDao.getAllForMovie(movieId);
    }

    @Override
    public List<Review> getLimitedForMovie(int movieId, int limitCount) {
        return reviewDao.getLimitedForMovie(movieId, limitCount);
    }

    @Override
    public void rateMovieRequest(RateMovieRequestDTO rateMovieRequestDTO) throws RestrictAccessException {

    }

    @Override
    public void addReviewRequest(AddReviewRequestDTO addReviewRequestDTO) throws RestrictAccessException {

    }

    @Override
    public void removeReviewRequest(Integer reviewId) throws RestrictAccessException {

    }
}
