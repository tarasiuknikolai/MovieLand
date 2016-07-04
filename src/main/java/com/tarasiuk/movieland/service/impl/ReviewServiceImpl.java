package com.tarasiuk.movieland.service.impl;

import com.tarasiuk.movieland.cache.SessionCache;
import com.tarasiuk.movieland.dao.ReviewDAO;
import com.tarasiuk.movieland.dto.request.AddReviewRequestDTO;
import com.tarasiuk.movieland.dto.request.RateMovieRequestDTO;
import com.tarasiuk.movieland.entity.Review;
import com.tarasiuk.movieland.security.Roles;
import com.tarasiuk.movieland.service.ReviewService;
import com.tarasiuk.movieland.service.exceptions.RestrictAccessException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    ReviewDAO reviewDao;

    @Autowired
    SessionCache sessionCache;

    @Override
    public List<Review> getAllForMovie(int movieId) {
        return reviewDao.getAllForMovie(movieId);
    }

    @Override
    public List<Review> getLimitedForMovie(int movieId, int limitCount) {
        return reviewDao.getLimitedForMovie(movieId, limitCount);
    }

    @Override
    public void rateMovieRequest(RateMovieRequestDTO rateMovieRequestDTO) {

    }

    @Override
    public void addReviewRequest(AddReviewRequestDTO addReviewRequestDTO) {
        Review review = modelMapper.map(addReviewRequestDTO, Review.class);
        reviewDao.addReview(review);
    }

    @Override
    public void removeReviewRequest(Integer reviewId, String token) {
        if (reviewDao.getReviewById(reviewId).getUserId() == sessionCache.getUserByToken(token).getId() ||
                sessionCache.isUserRoleByToken(token, new Roles[]{Roles.ADMIN})) {
            reviewDao.deleteReview(reviewId);
        } else {
            throw new RestrictAccessException("You cannot delete that review");
        }
    }
}
