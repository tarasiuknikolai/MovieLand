package com.tarasiuk.movieland.dao.jdbc;

import com.tarasiuk.movieland.dao.CountryDAO;
import com.tarasiuk.movieland.dao.jdbc.mapper.CountryRowMapper;
import com.tarasiuk.movieland.entity.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class JdbcCountryDAO implements CountryDAO {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private final CountryRowMapper countryRowMapper = new CountryRowMapper();

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Value("${sql.country.by.movieid}")
    private String getAllCountriesForMovieSQL;

    @Override
    public List<Country> getAllForMovie(int movieId) {
        log.info("Start query to get all countries for movie from DB");
        long startTime = System.currentTimeMillis();
        List<Country> countryList = jdbcTemplate.query(getAllCountriesForMovieSQL, new Object[]{movieId}, countryRowMapper);
        log.info("Finish query to get all countries for movies from DB. It took {} ms", System.currentTimeMillis() - startTime);
        return countryList;
    }
}
