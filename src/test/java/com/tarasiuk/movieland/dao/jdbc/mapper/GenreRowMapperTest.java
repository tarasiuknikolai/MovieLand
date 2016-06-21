package com.tarasiuk.movieland.dao.jdbc.mapper;

import com.tarasiuk.movieland.entity.Genre;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;


public class GenreRowMapperTest {
    @Test
    public void testMapRow() throws SQLException {
        ResultSet resultSet = mock(ResultSet.class);
        when(resultSet.getInt(any(String.class))).thenReturn(335);
        when(resultSet.getString(any(String.class))).thenReturn("GeNrE");

        GenreRowMapper genreMapper = new GenreRowMapper();
        Genre genre = genreMapper.mapRow(resultSet, 0);
        assertEquals(genre.getId(), 335);
        assertEquals(genre.getGenre(), "GeNrE");
    }
}
