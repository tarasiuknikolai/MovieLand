package com.tarasiuk.movieland.dao.jdbc;

import java.util.List;

import com.tarasiuk.movieland.dao.MovieDAO;
import com.tarasiuk.movieland.dao.jdbc.mapper.MovieRowMapper;
import com.tarasiuk.movieland.dto.request.AddMovieRequestDTO;
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

    @Value("${sql.movie.marked2del}")
    private String setMovieMarked2DelSQL;

    @Value("${sql.movie.delete.marked}")
    private String deleteMarkedMoviesSQL;

    @Value("${sql.movie.insert}")
    private String insertMovieSQL;

    @Value("${sql.get.last.id}")
    private String getLastIdSQL;

    @Value("${sql.movie.genre.insert}")
    private String insertMovieGenreSQL;

    @Value("${sql.movie.country.insert}")
    private String insertMovieCountrySQL;


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

    @Override
    public void updateMarked2Del(int movieId, int mark) {
        log.info("Start update movie to mark with {} for movieid {} into DB", mark, movieId);
        long startTime = System.currentTimeMillis();
        String chooseMark = (mark==0) ? null : "1";
        int count = jdbcTemplate.update(setMovieMarked2DelSQL, chooseMark , movieId);
        log.info("Finish {} update movie to mark with {} in DB. It took {} ms", count, mark, System.currentTimeMillis() - startTime);
    }

    @Override
    public void deleteMarkedMoviesFromDB() {
        log.info("Start delete marked movies");
        long startTime = System.currentTimeMillis();
        int count = jdbcTemplate.update(deleteMarkedMoviesSQL);
        log.info("Deleted {} movies. It took {} ms", count, System.currentTimeMillis() - startTime);
    }

    private void insertMovieCountry(int movieId, int countryId) {
        log.info("Start insert movieCountry");
        long startTime = System.currentTimeMillis();
        jdbcTemplate.update(insertMovieCountrySQL, new Object[]{movieId, countryId});
        log.info("Finish insert movieCountry with movieId = {}, countryId= {}. It took {} ms",  movieId, countryId, System.currentTimeMillis() - startTime);
    }

    private void insertMovieGenre(int movieId, int genreId) {
        log.info("Start insert movieGenre");
        long startTime = System.currentTimeMillis();
        jdbcTemplate.update(insertMovieGenreSQL, new Object[]{movieId, genreId});
        log.info("Finish insert movieGenre with movieId = {}, genreId= {}. It took {} ms",  movieId, genreId, System.currentTimeMillis() - startTime);
    }

    @Override
    public void insertMovie(AddMovieRequestDTO movie) {
        log.info("Start insert movie " + movie.getNameOrigin());
        long startTime = System.currentTimeMillis();
        jdbcTemplate.update(insertMovieSQL, new Object[]{movie.getNameRus(), movie.getNameOrigin(), movie.getYear(), movie.getDescription(), movie.getRating(), movie.getPrice()});
        int movieId = jdbcTemplate.queryForObject(getLastIdSQL, new Object []{"movie"}, Integer.class);
        for (Integer genreId : movie.getGenre()) {
            insertMovieGenre(movieId, genreId);
        }
        for (Integer countryId : movie.getCountry()) {
            insertMovieCountry(movieId, countryId);
        }
        log.info("Movie with id = {} is inserted. It took {} ms",  movieId, System.currentTimeMillis() - startTime);
    }
}
