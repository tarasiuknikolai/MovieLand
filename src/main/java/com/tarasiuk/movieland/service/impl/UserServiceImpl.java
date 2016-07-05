package com.tarasiuk.movieland.service.impl;

import com.tarasiuk.movieland.dao.UserDAO;
import com.tarasiuk.movieland.entity.User;
import com.tarasiuk.movieland.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDao;

    @Override
    public User getUserByCredentials(String email, String password) {
        return userDao.getUserByCredentials(email, password);
    }

    @Override
    public User getUserById(int userId) {
        return userDao.getUserById(userId);
    }

}
