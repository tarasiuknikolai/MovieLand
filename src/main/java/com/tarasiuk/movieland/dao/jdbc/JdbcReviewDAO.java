package com.tarasiuk.movieland.dao.jdbc;

import com.tarasiuk.movieland.dao.ReviewDAO;
import com.tarasiuk.movieland.dao.jdbc.mapper.ReviewRowMapper;
import com.tarasiuk.movieland.entity.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class JdbcReviewDAO implements ReviewDAO {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private final ReviewRowMapper reviewRowMapper = new ReviewRowMapper();

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private String getAllReviewForMovieSQL;

    @Autowired
    private String getLimitedReviewForMovieSQL;

    @Override
    public List<Review> getAllForMovie(int movieId) {
        log.info("Start query to get all review for movie from DB");
        long startTime = System.currentTimeMillis();
        List<Review> reviewList = jdbcTemplate.query(getAllReviewForMovieSQL, new Object[]{movieId} , reviewRowMapper);
        log.info("Finish query to get all reviews for movies from DB. It took {} ms", System.currentTimeMillis() - startTime);
        return reviewList;
    }

    @Override
    public List<Review> getLimitedForMovie(int movieId, int limitCount) {
        log.info("Start query {} rows to get reviews for movie from DB", limitCount);
        long startTime = System.currentTimeMillis();
        List<Review> reviewList = jdbcTemplate.query(getLimitedReviewForMovieSQL, new Object[]{movieId, limitCount} , reviewRowMapper);
        log.info("Finish query {} rows to get reviews for movie from DB. It took {} ms", limitCount, System.currentTimeMillis() - startTime);
        return reviewList;
    }

    @Override
    public void addReview(Review review) {
        jdbcTemplate.update("insert into review(movieid,userid,review) values (?,?,?)",review.getMovieid(), review.getUserid(), review.getReview());
//        jdbcTemplate.update("insert into review(movieid,userid,review) values (1,1,'WWTTFF')");
    }

    @Override
    public void deleteReview(Integer reviewId) {
        jdbcTemplate.update("delete from review where id = ?", reviewId);
    }

}
