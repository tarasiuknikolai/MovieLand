package com.tarasiuk.movieland.dao.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.tarasiuk.movieland.entity.MovieGenre;
import org.springframework.jdbc.core.RowMapper;

public class MovieGenreRowMapper implements RowMapper<MovieGenre> {
    @Override
    public MovieGenre mapRow(ResultSet resultSet, int i) throws SQLException {
        MovieGenre movieGenre = new MovieGenre();
        movieGenre.setId(resultSet.getInt("id"));
        movieGenre.setMovieId(resultSet.getInt("movieid"));
        movieGenre.setGenreId(resultSet.getInt("genreid"));
        return movieGenre;
    }
}




