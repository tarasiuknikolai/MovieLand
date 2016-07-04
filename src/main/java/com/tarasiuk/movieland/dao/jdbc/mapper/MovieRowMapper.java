package com.tarasiuk.movieland.dao.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.tarasiuk.movieland.entity.Movie;
import org.springframework.jdbc.core.RowMapper;


public class MovieRowMapper implements RowMapper<Movie> {
    @Override
    public Movie mapRow(ResultSet resultSet, int i) throws SQLException {
        Movie movie = new Movie();
        movie.setId(resultSet.getInt("id"));
        movie.setNameRus(resultSet.getString("namerus"));
        movie.setNameOrigin(resultSet.getString("nameorigin"));
        movie.setYear(resultSet.getInt("year"));
        movie.setDescription(resultSet.getString("description"));
        movie.setRating(resultSet.getDouble("rating"));
        movie.setPrice(resultSet.getDouble("price"));
        movie.setPoster(resultSet.getBytes("poster"));
        return movie;
    }
}