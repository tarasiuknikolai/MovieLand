package com.tarasiuk.movieland.dao.jdbc;

import java.util.List;

import com.tarasiuk.movieland.dao.MovieDAO;
import com.tarasiuk.movieland.dao.jdbc.mapper.MovieRowMapper;
import com.tarasiuk.movieland.dto.request.MovieQueryDTO;
import com.tarasiuk.movieland.entity.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcMovieDAO implements MovieDAO {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private final MovieRowMapper movieRowMapper = new MovieRowMapper();

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private QueryShaper queryShaper;

    @Autowired
    private String getMovieByIdSQL;

    @Autowired
    private String getAllMoviesSQL;

    @Autowired
    private String getPageMovieSQL;

    @Override
    public List<Movie> getAll(String ratingOrder, String priceOrder) {
        log.info("Start query to get all movies from DB");
        long startTime = System.currentTimeMillis();
        List<Movie> movieList = jdbcTemplate.query(queryShaper.formOrderClause(getAllMoviesSQL, ratingOrder, priceOrder), movieRowMapper);
        log.info("Finish query to get all movies from DB. It took {} ms", System.currentTimeMillis() - startTime);
        return movieList;
    }

    @Override
    public List<Movie> getAll(MovieQueryDTO queryQuestion) {
        log.info("Start query to get all movies from DB");
        long startTime = System.currentTimeMillis();
        List<Movie> movieList = jdbcTemplate.query(queryShaper.formWhereClause(getAllMoviesSQL, queryQuestion), movieRowMapper);
        log.info("Finish query to get all movies from DB. It took {} ms", System.currentTimeMillis() - startTime);
        return movieList;
    }

    @Override
    public Movie getById(int id) {
        log.info("Start query to get movie with id {} from DB", id);
        long startTime = System.currentTimeMillis();
        Movie movie = jdbcTemplate.queryForObject(getMovieByIdSQL, new Object[]{id}, movieRowMapper);
        log.info("Finish query to get movie with id {} from DB. It took {} ms", id, System.currentTimeMillis() - startTime);
        return movie;
    }

    @Override
    public List<Movie> getPage (Integer pageNumber) {
        log.info("Start query to get {} page with movies from DB", pageNumber);
        long startTime = System.currentTimeMillis();
        List<Movie> movieList = jdbcTemplate.query(getPageMovieSQL, new Object[]{pageNumber-1, pageNumber}, movieRowMapper);
        log.info("Finish query to get {} page with movies from DB. It took {} ms", System.currentTimeMillis() - startTime);
        return movieList;
    }


}
