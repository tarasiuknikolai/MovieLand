package com.tarasiuk.movieland.service.security;

import com.tarasiuk.movieland.cache.SessionCache;
import com.tarasiuk.movieland.dao.ReviewDAO;
import com.tarasiuk.movieland.service.ReviewService;
import com.tarasiuk.movieland.service.exceptions.RestrictAccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewSecurityService {

    @Autowired
    private SessionCache sessionCache;

    @Autowired
    private ReviewDAO reviewDao;

    @Autowired
    private ReviewService reviewService;

    public void deleteReview(Integer reviewId, String token) {
        if (reviewDao.getReviewById(reviewId).getUserId() == sessionCache.getUserByToken(token).getId() ||
                sessionCache.isUserRoleByToken(token, new Roles[]{Roles.ADMIN})) {
            reviewService.deleteReview(reviewId);
        } else {
            throw new RestrictAccessException("You cannot delete that review");
        }
    }

}
