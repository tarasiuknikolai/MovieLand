package com.tarasiuk.movieland.dao.jdbc;

import java.util.List;

import com.tarasiuk.movieland.dao.MovieDAO;
import com.tarasiuk.movieland.dao.jdbc.mapper.MovieRowMapper;
import com.tarasiuk.movieland.dto.request.GetMovieRequestDTO;
import com.tarasiuk.movieland.dto.request.SearchMovieRequestDTO;
import com.tarasiuk.movieland.entity.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${sql.movie.by.id}")
    private String getMovieByIdSQL;

    @Value("${sql.movie.all}")
    private String getAllMoviesSQL;

    @Value("${movie.pagesize:5}")
    private int pageSize;

    @Value("${sql.movie.update.rating}")
    private String updateMovieRatingSQL;

    @Override
    public List<Movie> getAll(SearchMovieRequestDTO queryQuestion) {
        log.info("Start query with conditions to get movies from DB");
        long startTime = System.currentTimeMillis();
        List<Movie> movieList = jdbcTemplate.query(queryShaper.formWhereClause(getAllMoviesSQL, queryQuestion), movieRowMapper);
        log.info("Finish query with conditions to get movies from DB. It took {} ms", System.currentTimeMillis() - startTime);
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
    public List<Movie> getAll(GetMovieRequestDTO getMovieRequestDTO) {
        log.info("Start query to get movies from DB");
        long startTime = System.currentTimeMillis();
        List<Movie> movieList = jdbcTemplate.query(queryShaper.formOrderClause(getAllMoviesSQL, getMovieRequestDTO, pageSize), movieRowMapper);
        log.info("Finish query to get movies from DB. It took {} ms", System.currentTimeMillis() - startTime);
        return movieList;
    }

    @Override
    public void updateRatingValue(int movieId) {
        log.info("Start update movie rating for movieid {} into DB", movieId);
        long startTime = System.currentTimeMillis();
        int count = jdbcTemplate.update(updateMovieRatingSQL, movieId);
        log.info("Finish {} update movie review in DB. It took {} ms", count, System.currentTimeMillis() - startTime);
    }

}
