package com.tarasiuk.movieland.dao.jdbc.mapper;

import com.tarasiuk.movieland.entity.Movie;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;


public class MovieRowMapperTest {
    @Test
    public void testMapRow() throws SQLException {
        ResultSet resultSet = mock(ResultSet.class);
        when(resultSet.getInt(any(String.class))).thenReturn(1).thenReturn(1980);
        when(resultSet.getString(any(String.class))).thenReturn("rus name").thenReturn("origin name")
                .thenReturn("descr");
        when(resultSet.getDouble(any(String.class))).thenReturn(10d).thenReturn(100d);

        MovieRowMapper movieMapper = new MovieRowMapper();
        Movie movie = movieMapper.mapRow(resultSet, 0);
        assertEquals(movie.getId(), 1);
        assertEquals(movie.getNameRus(), "rus name");
        assertEquals(movie.getNameOrigin(), "origin name");
        assertEquals(movie.getYear(), 1980);
        assertEquals(movie.getDescription(), "descr");
        assertEquals(movie.getRating(), 10d, 0d);
        assertEquals(movie.getPrice(), 100d, 0d);
    }
}
