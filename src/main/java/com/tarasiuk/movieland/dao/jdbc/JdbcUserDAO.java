package com.tarasiuk.movieland.dao.jdbc;

import com.tarasiuk.movieland.dao.UserDAO;
import com.tarasiuk.movieland.dao.jdbc.mapper.UserRowMapper;
import com.tarasiuk.movieland.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcUserDAO implements UserDAO {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final UserRowMapper userRowMapper = new UserRowMapper();

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private String getUserByCredentialsSQL;

    @Autowired
    private String getUserByIdSQL;

    @Override
    public User getUserByCredentials(String email, String password) {
        log.info("Start query to get user with email {} from DB", email);
        long startTime = System.currentTimeMillis();
        User user = jdbcTemplate.queryForObject(getUserByCredentialsSQL, new Object[]{email, password}, userRowMapper);
        log.info("Finish query to get user with email {} from DB. It took {} ms", email, System.currentTimeMillis() - startTime);
        return user;
    }

    @Override
    public User getUserById(int userId) {
        log.info("Start query to get user with ID {} from DB", userId);
        long startTime = System.currentTimeMillis();
        User user = jdbcTemplate.queryForObject(getUserByIdSQL, new Object[]{userId}, userRowMapper);
        log.info("Finish query to get user with ID {} from DB. It took {} ms", userId, System.currentTimeMillis() - startTime);
        return user;
    }
}
