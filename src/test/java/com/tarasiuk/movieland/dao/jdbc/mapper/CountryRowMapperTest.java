package com.tarasiuk.movieland.dao.jdbc.mapper;

import com.tarasiuk.movieland.entity.Country;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;


public class CountryRowMapperTest {
    @Test
    public void testMapRow() throws SQLException {
        ResultSet resultSet = mock(ResultSet.class);
        when(resultSet.getInt(any(String.class))).thenReturn(335);
        when(resultSet.getString(any(String.class))).thenReturn("CoUnTrY");

        CountryRowMapper countryMapper = new CountryRowMapper();
        Country country = countryMapper.mapRow(resultSet, 0);
        assertEquals(country.getId(), 335);
        assertEquals(country.getCountry(), "CoUnTrY");
    }
}
