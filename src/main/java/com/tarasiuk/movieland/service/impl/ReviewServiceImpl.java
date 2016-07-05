package com.tarasiuk.movieland.service.impl;

import com.tarasiuk.movieland.dao.ReviewDAO;
import com.tarasiuk.movieland.dto.request.AddReviewRequestDTO;
import com.tarasiuk.movieland.entity.Review;
import com.tarasiuk.movieland.service.ReviewService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private ReviewDAO reviewDao;

    @Override
    public List<Review> getAllForMovie(int movieId) {
        return reviewDao.getAllForMovie(movieId);
    }

    @Override
    public List<Review> getLimitedForMovie(int movieId, int limitCount) {
        return reviewDao.getLimitedForMovie(movieId, limitCount);
    }

    @Override
    public void addReview(AddReviewRequestDTO addReviewRequestDTO) {
        Review review = modelMapper.map(addReviewRequestDTO, Review.class);
        reviewDao.addReview(review);
    }

    @Override
    public void deleteReview(int reviewId) {
        reviewDao.deleteReview(reviewId);
    }

}
