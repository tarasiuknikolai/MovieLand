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
        movie.setNamerus(resultSet.getString("namerus"));
        movie.setNameeng(resultSet.getString("nameeng"));
        movie.setYr(resultSet.getInt("yr"));
        movie.setDescr(resultSet.getString("descr"));
        movie.setRating(resultSet.getInt("rating"));
        movie.setPrice(resultSet.getInt("price"));
        return movie;
    }
}