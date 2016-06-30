package com.tarasiuk.movieland.dao.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.tarasiuk.movieland.entity.Genre;
import org.springframework.jdbc.core.RowMapper;


public class GenreRowMapper implements RowMapper<Genre> {
    @Override
    public Genre mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Genre(resultSet.getInt("id"), resultSet.getString("genre"));
    }
}
