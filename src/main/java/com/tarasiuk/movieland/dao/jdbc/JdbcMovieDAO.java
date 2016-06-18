package com.tarasiuk.movieland.dao.jdbc;

import java.util.List;
import com.tarasiuk.movieland.dao.MovieDAO;
import com.tarasiuk.movieland.dao.jdbc.mapper.MovieRowMapper;
import com.tarasiuk.movieland.entity.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcMovieDAO implements MovieDAO {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private String getMovieByIdSQL;

    @Autowired
    private String getAllMoviesSQL;

    private String formOrderClause(String ratingOrder, String priceOrder) {
        StringBuilder orderClause = new StringBuilder();
        if (ratingOrder != null || priceOrder != null) {
            orderClause.append(OrderClause.contains(ratingOrder)? ", rating " + ratingOrder : "");
            orderClause.append(OrderClause.contains(priceOrder)? ", price " + priceOrder : "");
        }
        return (orderClause.length() > 0) ? orderClause.insert(0, " ORDER BY 'a'").toString() : "" ;
    }

    @Override
    public List<Movie> getAll(String ratingOrder, String priceOrder) {
        log.info("Start query to get all movies from DB");
        long startTime = System.currentTimeMillis();
        List<Movie> movieList = jdbcTemplate.query(getAllMoviesSQL + formOrderClause(ratingOrder, priceOrder),  new MovieRowMapper());
        log.info("Finish query to get all movies from DB. It took {} ms", System.currentTimeMillis() - startTime);
        return movieList;
    }

    @Override
    public Movie getById(int id) {
        log.info("Start query to get movie with id {} from DB", id);
        long startTime = System.currentTimeMillis();
        Movie movie = jdbcTemplate.queryForObject(getMovieByIdSQL, new Object[]{id}, new MovieRowMapper());
        log.info("Finish query to get movie with id {} from DB. It took {} ms", id, System.currentTimeMillis() - startTime);
        return movie;
    }

}
