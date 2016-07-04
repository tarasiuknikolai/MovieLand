package com.tarasiuk.movieland.dao.jdbc.mapper;

import com.tarasiuk.movieland.entity.Poster;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PosterRowMapper implements RowMapper<Poster> {
    @Override
    public Poster mapRow(ResultSet resultSet, int i) throws SQLException {
        Poster poster = new Poster();
        poster.setId(resultSet.getInt("id"));
        poster.setMovieId(resultSet.getInt("movieid"));
        poster.setPoster(resultSet.getBytes("poster"));
        return poster;
    }
}
