package com.tarasiuk.movieland.dao.mapper;

import com.tarasiuk.movieland.dao.jdbc.mapper.ReviewRowMapper;
import com.tarasiuk.movieland.entity.Review;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;

public class ReviewRowMapperTest {
    @Test
    public void testMapRow() throws SQLException {
        ResultSet resultSet = mock(ResultSet.class);
        when(resultSet.getInt(any(String.class))).thenReturn(8).thenReturn(13).thenReturn(21);
        when(resultSet.getString(any(String.class))).thenReturn("ReViEw");

        ReviewRowMapper reviewMapper = new ReviewRowMapper();
        Review review = reviewMapper.mapRow(resultSet, 0);
        assertEquals(review.getId(), 8);
        assertEquals(review.getMovieid(), 13);
        assertEquals(review.getUserid(), 21);
        assertEquals(review.getReview(), "ReViEw");
    }

}
