package com.tarasiuk.movieland.service.impl;

import com.tarasiuk.movieland.dao.MovieDao;
import com.tarasiuk.movieland.entity.Movie;
import com.tarasiuk.movieland.service.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieDao movieDao;

    @Override
    public Movie getById(int id) {
        return movieDao.getById(id);
    }

}
