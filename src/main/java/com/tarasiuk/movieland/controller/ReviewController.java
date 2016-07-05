package com.tarasiuk.movieland.controller;

import com.tarasiuk.movieland.dto.SimpleResponseDTO;
import com.tarasiuk.movieland.dto.request.AddReviewRequestDTO;
import com.tarasiuk.movieland.service.security.ReviewSecurityService;
import com.tarasiuk.movieland.service.security.Roles;
import com.tarasiuk.movieland.service.ReviewService;
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
public class ReviewController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private ReviewSecurityService reviewSecurityService;

    @AllowedRoles(roles = {Roles.USER, Roles.ADMIN})
    @RequestMapping(value = "/review", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> putReview(@RequestBody AddReviewRequestDTO addReviewRequestDTO,
                                       @RequestHeader(value = "authToken") String token) throws RestrictAccessException {
        log.info("Attempt to add new review");
        long startTime = System.currentTimeMillis();
        reviewService.addReview(addReviewRequestDTO);
        log.info("Review was added. It took {} ms", System.currentTimeMillis() - startTime);
        SimpleResponseDTO simpleResponseDTO = new SimpleResponseDTO("OK");
        return new ResponseEntity<>(simpleResponseDTO, HttpStatus.OK);
    }

    @AllowedRoles(roles = {Roles.USER, Roles.ADMIN})
    @RequestMapping(value = "/review", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<?> deleteReview(@RequestBody AddReviewRequestDTO addReviewRequestDTO,
                                          @RequestHeader(value = "authToken") String token) throws RestrictAccessException {
        log.info("Attempt to delete review");
        long startTime = System.currentTimeMillis();
        reviewSecurityService.deleteReview(addReviewRequestDTO.getId(), token);
        log.info("Review was deleted. It took {} ms", System.currentTimeMillis() - startTime);
        SimpleResponseDTO simpleResponseDTO = new SimpleResponseDTO("OK");
        return new ResponseEntity<>(simpleResponseDTO, HttpStatus.OK);
    }

}
