package com.tarasiuk.movieland.controller;

import com.tarasiuk.movieland.dto.SimpleResponseDTO;
import com.tarasiuk.movieland.dto.request.RatingRequestDTO;
import com.tarasiuk.movieland.service.MovieService;
import com.tarasiuk.movieland.service.RatingService;
import com.tarasiuk.movieland.service.exceptions.RestrictAccessException;
import com.tarasiuk.movieland.utils.AllowedRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/v1")
public class RatingController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private RatingService ratingService;

    @Autowired
    private MovieService movieService;


    @AllowedRoles(roles = {"USER", "ADMIN"})
    @RequestMapping(value = "/rate", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> putRating(@RequestBody RatingRequestDTO ratingRequestDTO,
                                       @RequestHeader(value = "authToken") String token) throws RestrictAccessException {
        ratingService.putRating(ratingRequestDTO);
        movieService.updateMovieReview(ratingRequestDTO.getMovieId());
        SimpleResponseDTO simpleResponseDTO = new SimpleResponseDTO();
        simpleResponseDTO.setMessage("OK");
        return new ResponseEntity<>(simpleResponseDTO, HttpStatus.OK);
    }

}
