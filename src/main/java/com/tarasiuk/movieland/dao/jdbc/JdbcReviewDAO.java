package com.tarasiuk.movieland.dao.jdbc;

import com.tarasiuk.movieland.dao.ReviewDAO;
import com.tarasiuk.movieland.dao.jdbc.mapper.ReviewRowMapper;
import com.tarasiuk.movieland.entity.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcReviewDAO implements ReviewDAO {

    private final Logger log = LoggerFactory.getLogger(getClass());
    private final ReviewRowMapper reviewRowMapper = new ReviewRowMapper();

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Value("${sql.review.by.movieid}")
    private String getAllReviewForMovieSQL;

    @Value("${sql.review.by.movieid.limited}")
    private String getLimitedReviewForMovieSQL;

    @Value("${sql.review.insert}")
    private String insertReviewSQL;

    @Value("${sql.review.delete}")
    private String deleteReviewByIDSQL;

    @Value("${sql.review.by.id}")
    private String getReviewByIdSQL;


    @Override
    public List<Review> getAllForMovie(int movieId) {
        log.info("Start query to get all review for movie from DB");
        long startTime = System.currentTimeMillis();
        List<Review> reviewList = jdbcTemplate.query(getAllReviewForMovieSQL, new Object[]{movieId}, reviewRowMapper);
        log.info("Finish query to get all reviews for movies from DB. It took {} ms", System.currentTimeMillis() - startTime);
        return reviewList;
    }

    @Override
    public List<Review> getLimitedForMovie(int movieId, int limitCount) {
        log.info("Start query {} rows to get reviews for movie from DB", limitCount);
        long startTime = System.currentTimeMillis();
        List<Review> reviewList = jdbcTemplate.query(getLimitedReviewForMovieSQL, new Object[]{movieId, limitCount}, reviewRowMapper);
        log.info("Finish query {} rows to get reviews for movie from DB. It took {} ms", limitCount, System.currentTimeMillis() - startTime);
        return reviewList;
    }

    @Override
    public void addReview(Review review) {
        log.info("Start insert review for movie into DB");
        long startTime = System.currentTimeMillis();
        int count = jdbcTemplate.update(insertReviewSQL, review.getMovieid(), review.getUserid(), review.getReview());
        log.info("Inserted {} review for movie to DB. It took {} ms", count, System.currentTimeMillis() - startTime);
    }

    @Override
    public void deleteReview(Integer reviewId, Integer userId) {
        log.info("Start delete review with id = {} for movie by user with id = {}", reviewId, userId);
        long startTime = System.currentTimeMillis();
        int count = jdbcTemplate.update(deleteReviewByIDSQL, reviewId, userId);
        log.info("Deleted {} review with id = {}. It took {} ms", count, reviewId, System.currentTimeMillis() - startTime);
    }

    @Override
    public Review getReviewById(int reviewId) {
        log.info("Start query to get review with id {} from DB", reviewId);
        long startTime = System.currentTimeMillis();
        Review review = jdbcTemplate.queryForObject(getReviewByIdSQL, new Object[]{reviewId}, reviewRowMapper);
        log.info("Finish query to get review with id {} from DB. It took {} ms", reviewId, System.currentTimeMillis() - startTime);
        return review;
    }
}
