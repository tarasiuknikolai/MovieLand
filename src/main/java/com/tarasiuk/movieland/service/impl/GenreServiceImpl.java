package com.tarasiuk.movieland.service.impl;

import com.tarasiuk.movieland.cache.GenreCache;
import com.tarasiuk.movieland.dao.GenreDAO;
import com.tarasiuk.movieland.entity.Genre;
import com.tarasiuk.movieland.entity.MovieGenre;
import com.tarasiuk.movieland.service.GenreService;
import com.tarasiuk.movieland.service.MovieGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
    @Autowired
    private GenreDAO genreDao;

    @Autowired
    private MovieGenreService movieGenreService;

    @Autowired
    private GenreCache genreCache;

    @Override
    public List<Genre> getAllForMovie(int movieId) {
        List<Genre> listGenre = new ArrayList<>();
        for (MovieGenre movieGenre : movieGenreService.getAllForMovie(movieId)) {
            listGenre.add(genreCache.getById(movieGenre.getGenreId()));
        }
        return listGenre;
    }

    @Override
    public List<Genre> getAll() {
        return genreDao.getAll();
    }

    @Override
    public Genre getById(int genreId) {
        return genreDao.getById(genreId);
    }
}
