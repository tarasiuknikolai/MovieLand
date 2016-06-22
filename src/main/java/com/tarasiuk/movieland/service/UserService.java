package com.tarasiuk.movieland.service;

import com.tarasiuk.movieland.entity.User;

public interface UserService {

    User getUserByCredentials(String email, String password);

    User getUserById(int userId);

}
