package com.tarasiuk.movieland.dao.jdbc;

import com.tarasiuk.movieland.dao.GenreDAO;
import com.tarasiuk.movieland.dao.jdbc.mapper.GenreRowMapper;
import com.tarasiuk.movieland.entity.Genre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcGenreDAO implements GenreDAO {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private final GenreRowMapper genreRowMapper = new GenreRowMapper();

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private String getAllGenresForMovieSQL;

    @Autowired
    private String getAllGenresForCache;

    @Override
    public List<Genre> getAllForMovie(int movieId) {
        log.info("Start query to get all genres for movie from DB");
        long startTime = System.currentTimeMillis();
        List<Genre> genreList = jdbcTemplate.query(getAllGenresForMovieSQL, new Object[]{movieId}, genreRowMapper);
        log.info("Finish query to get all genres for movie from DB. It took {} ms", System.currentTimeMillis() - startTime);
        return genreList;
    }

    @Override
    public List<Genre> getAll() {
        log.info("Start query to get all genres for Cache from DB");
        long startTime = System.currentTimeMillis();
        List<Genre> genreList = jdbcTemplate.query(getAllGenresForCache, new GenreRowMapper());
        log.info("Finish query to get all genres for Cache from DB. It took {} ms", System.currentTimeMillis() - startTime);
        return genreList;
    }
}