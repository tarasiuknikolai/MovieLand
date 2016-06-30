package com.tarasiuk.movieland.service.impl;

import com.tarasiuk.movieland.dao.RatingDAO;
import com.tarasiuk.movieland.dto.request.RatingRequestDTO;
import com.tarasiuk.movieland.entity.Rating;
import com.tarasiuk.movieland.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    RatingDAO ratingDAO;


    @Override
    public void putRating(RatingRequestDTO ratingRequestDTO) {
        ratingDAO.deleteRating(ratingRequestDTO);
        ratingDAO.addRating(ratingRequestDTO);
    }


    @Override
    public Rating getRatingById(int ratingId) {
        return null;
    }

    @Override
    public Rating getRatingByMovieId(int movieId) {
        return null;
    }

    @Override
    public Rating getRatingByUserId(int userId) {
        return null;
    }
}
