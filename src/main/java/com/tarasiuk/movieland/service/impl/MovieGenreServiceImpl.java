package com.tarasiuk.movieland.service.impl;

import com.tarasiuk.movieland.dao.MovieGenreDAO;
import com.tarasiuk.movieland.entity.MovieGenre;
import com.tarasiuk.movieland.service.MovieGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieGenreServiceImpl implements MovieGenreService {
    @Autowired
    MovieGenreDAO movieGenreDao;

    @Override
    public List<MovieGenre> getAllForMovie(int movieId) {
        return movieGenreDao.getAllForMovie(movieId);
    }
}
