package com.tarasiuk.movieland.service.impl;

import com.tarasiuk.movieland.dao.GenreDAO;
import com.tarasiuk.movieland.entity.Genre;
import com.tarasiuk.movieland.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
    @Autowired
    private GenreDAO genreDao;

    @Override
    public List<Genre> getAllForMovie(int movieId) {
        return genreDao.getAllForMovie(movieId);
    }

    @Override
    public List<Genre> getAll() {
        return genreDao.getAll();
    }

}
