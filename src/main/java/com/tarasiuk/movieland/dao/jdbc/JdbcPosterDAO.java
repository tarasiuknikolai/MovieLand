package com.tarasiuk.movieland.dao.jdbc;

import com.tarasiuk.movieland.dao.PosterDAO;
import com.tarasiuk.movieland.dao.jdbc.mapper.PosterRowMapper;
import com.tarasiuk.movieland.entity.Poster;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcPosterDAO implements PosterDAO{

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final PosterRowMapper posterRowMapper = new PosterRowMapper();

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Value("${sql.poster.get.by.movieid}")
    private String getPosterByMovieId;


    @Override
    public Poster getPosterByMovieId(int movieId) {
        log.info("Start query to get poster for movie {} from DB");
        long startTime = System.currentTimeMillis();
        Poster poster = jdbcTemplate.queryForObject(getPosterByMovieId, new Object[]{movieId}, posterRowMapper);
        log.info("Finish query to get all countries for movies from DB. It took {} ms", System.currentTimeMillis() - startTime);
        return poster;
    }
}
