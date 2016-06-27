package com.tarasiuk.movieland.controller;

import com.tarasiuk.movieland.dto.SimpleResponseDTO;
import com.tarasiuk.movieland.dto.request.AddReviewRequestDTO;
import com.tarasiuk.movieland.service.ReviewService;
import com.tarasiuk.movieland.service.exceptions.RestrictAccessException;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/v1")
public class ReviewController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private ReviewService reviewService;

    @RequestMapping(value = "/review", method = RequestMethod.POST)
    @ResponseBody
    public SimpleResponseDTO putReview(@RequestBody AddReviewRequestDTO addReviewRequestDTO) throws RestrictAccessException {
        log.info("");
        long startTime = System.currentTimeMillis();
        reviewService.addReviewRequest(addReviewRequestDTO);
        log.info("It took {} ms", System.currentTimeMillis() - startTime);
        SimpleResponseDTO simpleResponseDTO = new SimpleResponseDTO();
        simpleResponseDTO.setMessage("OK");
        return simpleResponseDTO;
    }

    @RequestMapping(value = "/review", method = RequestMethod.DELETE)
    @ResponseBody
    public SimpleResponseDTO deleteReview(@RequestBody AddReviewRequestDTO addReviewRequestDTO) throws RestrictAccessException  {
        log.info("");
        long startTime = System.currentTimeMillis();
        reviewService.removeReviewRequest(addReviewRequestDTO.getId());
        log.info("It took {} ms", System.currentTimeMillis() - startTime);
        SimpleResponseDTO simpleResponseDTO = new SimpleResponseDTO();
        simpleResponseDTO.setMessage("OK");
        return simpleResponseDTO;
    }

}
