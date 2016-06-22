package com.tarasiuk.movieland.dao;

import com.tarasiuk.movieland.entity.User;

public interface UserDAO {

    User getUserByCredentials(String email, String password);

}
