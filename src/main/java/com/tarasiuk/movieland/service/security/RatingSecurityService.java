package com.tarasiuk.movieland.service.security;


import com.tarasiuk.movieland.dto.request.RatingRequestDTO;
import com.tarasiuk.movieland.entity.Rating;
import com.tarasiuk.movieland.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingSecurityService {

    @Autowired
    private RatingService ratingService;


    public void putRating(RatingRequestDTO ratingRequestDTO) {
        for (Rating rating : ratingService.getRatingByUserId(ratingRequestDTO.getUserId())) {
            if (rating.getUserId() == ratingRequestDTO.getUserId()) {
                ratingService.deleteRating(ratingRequestDTO);
            }
        }
        ratingService.addRating(ratingRequestDTO);
    }

}
