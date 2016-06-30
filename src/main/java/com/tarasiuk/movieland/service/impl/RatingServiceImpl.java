package com.tarasiuk.movieland.service.impl;

import com.tarasiuk.movieland.dao.RatingDAO;
import com.tarasiuk.movieland.dto.request.RatingRequestDTO;
import com.tarasiuk.movieland.entity.Rating;
import com.tarasiuk.movieland.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    RatingDAO ratingDAO;


    @Override
    public void putRating(RatingRequestDTO ratingRequestDTO) {
        if (ratingRequestDTO.getRating() < 1 || ratingRequestDTO.getRating() > 10) {
            throw new IllegalArgumentException("Rating should be between 1 and 10");
        }

        for (Rating rating : ratingDAO.getRatingByMovieId(ratingRequestDTO.getMovieId())) {
            if (rating.getUserId() == ratingRequestDTO.getUserId()) {
                ratingDAO.deleteRating(ratingRequestDTO);
            }
        }
        ratingDAO.addRating(ratingRequestDTO);
    }


    @Override
    public Rating getRatingById(int ratingId) {
        return ratingDAO.getRatingById(ratingId);
    }

    @Override
    public List<Rating> getRatingByMovieId(int movieId) {
        return ratingDAO.getRatingByMovieId(movieId);
    }

    @Override
    public List<Rating> getRatingByUserId(int userId) {
        return ratingDAO.getRatingByUserId(userId);
    }
}
