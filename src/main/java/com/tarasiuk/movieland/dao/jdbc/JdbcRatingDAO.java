package com.tarasiuk.movieland.dao.jdbc;

import com.tarasiuk.movieland.dao.RatingDAO;
import com.tarasiuk.movieland.dao.jdbc.mapper.RatingRowMapper;
import com.tarasiuk.movieland.dto.request.RatingRequestDTO;
import com.tarasiuk.movieland.entity.Rating;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcRatingDAO implements RatingDAO {

    private final Logger log = LoggerFactory.getLogger(getClass());
    private final RatingRowMapper ratingRowMapper = new RatingRowMapper();

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Value("${sql.rating.insert}")
    private String insertRatingSQL;

    @Value("${sql.rating.delete}")
    private String deleteRatingSQL;

    @Value("${sql.rating.get.by.id}")
    private String getRatingByIdSQL;

    @Value("${sql.rating.get.by.movieid}")
    private String getRatingByMovieIdSQL;

    @Value("${sql.rating.get.by.userid}")
    private String getRatingByUserIdSQL;


    @Override
    public void addRating(RatingRequestDTO ratingRequestDTO) {
        log.info("Start insert rating for movie into DB");
        long startTime = System.currentTimeMillis();
        int count = jdbcTemplate.update(insertRatingSQL, ratingRequestDTO.getMovieId(), ratingRequestDTO.getUserId(), ratingRequestDTO.getRating());
        log.info("Inserted {} rating for movie to DB. It took {} ms", count, System.currentTimeMillis() - startTime);
    }

    @Override
    public void deleteRating(RatingRequestDTO ratingRequestDTO) {
        log.info("Start update rating for movie");
        long startTime = System.currentTimeMillis();
        int count = jdbcTemplate.update(deleteRatingSQL, ratingRequestDTO.getMovieId(), ratingRequestDTO.getUserId());
        log.info("Updated {} rating for movie. It took {} ms", count, System.currentTimeMillis() - startTime);
    }

    @Override
    public Rating getRatingById(int id) {
        log.info("Start query to get Rating with id {} from DB", id);
        long startTime = System.currentTimeMillis();
        Rating rating = jdbcTemplate.queryForObject(getRatingByIdSQL, new Object[]{id}, ratingRowMapper);
        log.info("Finish query to get Rating with id {} from DB. It took {} ms", id, System.currentTimeMillis() - startTime);
        return rating;
    }

    @Override
    public List<Rating> getRatingByMovieId(int movieId) {
        log.info("Start query to get Rating with movieid {} from DB", movieId);
        long startTime = System.currentTimeMillis();
        List<Rating> rating = jdbcTemplate.query(getRatingByMovieIdSQL, new Object[]{movieId}, ratingRowMapper);
        log.info("Finish query to get Rating with movieid {} from DB. It took {} ms", movieId, System.currentTimeMillis() - startTime);
        return rating;
    }

    @Override
    public List<Rating> getRatingByUserId(int userId) {
        log.info("Start query to get Rating with userid {} from DB", userId);
        long startTime = System.currentTimeMillis();
        List<Rating> rating = jdbcTemplate.query(getRatingByUserIdSQL, new Object[]{userId}, ratingRowMapper);
        log.info("Finish query to get Rating with userid {} from DB. It took {} ms", userId, System.currentTimeMillis() - startTime);
        return rating;
    }

}
