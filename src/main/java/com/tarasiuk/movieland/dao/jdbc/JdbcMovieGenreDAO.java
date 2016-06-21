package com.tarasiuk.movieland.dao.jdbc;

import com.tarasiuk.movieland.dao.MovieGenreDAO;
import com.tarasiuk.movieland.dao.jdbc.mapper.MovieGenreRowMapper;
import com.tarasiuk.movieland.entity.MovieGenre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcMovieGenreDAO implements MovieGenreDAO{
    private final Logger log = LoggerFactory.getLogger(getClass());
    private final MovieGenreRowMapper movieGenreRowMapper = new MovieGenreRowMapper();
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private String getAllMovieGenresForMovieSQL;


    @Override
    public List<MovieGenre> getAllForMovie(int movieId) {
        log.info("Start query to get all movies-genres for movie from DB");
        long startTime = System.currentTimeMillis();
        List<MovieGenre> movieGenreList = jdbcTemplate.query(getAllMovieGenresForMovieSQL, new Object[]{movieId}, movieGenreRowMapper);
        log.info("Finish query to get all movies-genres for movie from DB. It took {} ms", System.currentTimeMillis() - startTime);
        return movieGenreList;
    }
}
