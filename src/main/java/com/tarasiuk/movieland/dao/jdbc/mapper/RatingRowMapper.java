package com.tarasiuk.movieland.dao.jdbc.mapper;

import com.tarasiuk.movieland.entity.Rating;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RatingRowMapper implements RowMapper<Rating> {
    @Override
    public Rating mapRow(ResultSet resultSet, int i) throws SQLException {
        Rating rating = new Rating();
        rating.setId(resultSet.getInt("id"));
        rating.setMovieId(resultSet.getInt("movieid"));
        rating.setUserId(resultSet.getInt("userid"));
        rating.setRating(resultSet.getDouble("rating"));
        return rating;
    }
}
