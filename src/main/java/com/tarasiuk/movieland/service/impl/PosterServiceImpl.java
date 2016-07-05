package com.tarasiuk.movieland.service.impl;

import com.tarasiuk.movieland.dao.PosterDAO;
import com.tarasiuk.movieland.entity.Poster;
import com.tarasiuk.movieland.service.PosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PosterServiceImpl implements PosterService {

    @Autowired
    private PosterDAO posterDAO;

    @Override
    public Poster getPosterByMovieId(int movieId) {
        return posterDAO.getPosterByMovieId(movieId);
    }
}
