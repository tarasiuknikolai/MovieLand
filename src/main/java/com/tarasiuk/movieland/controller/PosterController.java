package com.tarasiuk.movieland.controller;

import com.tarasiuk.movieland.service.PosterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/v1")
public class PosterController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private PosterService posterService;

    @RequestMapping(value = "/poster/{movieId}", produces = MediaType.IMAGE_JPEG_VALUE, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<byte[]> getMovieById(@PathVariable int movieId) {
        log.info("Sending request to get poster for movie with id = {}",movieId);
        long startTime = System.currentTimeMillis();
        byte[] poster = posterService.getPosterByMovieId(movieId).getPoster();
        log.info("Movie`s poster is received. It took {} ms", System.currentTimeMillis() - startTime);
        return new ResponseEntity<>(poster , HttpStatus.OK);
    }

}
