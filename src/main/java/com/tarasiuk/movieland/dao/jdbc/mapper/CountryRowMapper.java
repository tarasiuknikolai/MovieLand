package com.tarasiuk.movieland.dao.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.tarasiuk.movieland.entity.Country;
import org.springframework.jdbc.core.RowMapper;


public class CountryRowMapper implements RowMapper<Country> {
    @Override
    public Country mapRow(ResultSet resultSet, int i) throws SQLException {
        Country country = new Country();
        country.setId(resultSet.getInt("id"));
        country.setCountry(resultSet.getString("country"));
        return country;
    }
}
