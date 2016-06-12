package com.tarasiuk.movieland.service.impl;

import com.tarasiuk.movieland.dao.ReviewDAO;
import com.tarasiuk.movieland.entity.Review;
import com.tarasiuk.movieland.service.ReviewService;
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
    public List<Review> getLimitedForMovie(int movieId, int limitCnt) {
        return reviewDao.getLimitedForMovie(movieId, limitCnt);
    }
}
