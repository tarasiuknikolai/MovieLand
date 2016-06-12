package com.tarasiuk.movieland.dao.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.tarasiuk.movieland.entity.Review;
import org.springframework.jdbc.core.RowMapper;


public class ReviewRowMapper  implements RowMapper<Review> {
    @Override
    public Review mapRow(ResultSet resultSet, int i) throws SQLException {
        Review review = new Review();
        review.setId(resultSet.getInt("id"));
        review.setMovieid(resultSet.getInt("movieid"));
        review.setUserid(resultSet.getInt("userid"));
        review.setReview(resultSet.getString("review"));
        return review;
    }

}
