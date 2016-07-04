package com.tarasiuk.movieland.service.impl;

import com.tarasiuk.movieland.cache.SessionCache;
import com.tarasiuk.movieland.dto.request.AuthRequestDTO;
import com.tarasiuk.movieland.service.SecurityService;
import com.tarasiuk.movieland.service.UserService;
import com.tarasiuk.movieland.service.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tarasiuk.movieland.service.exceptions.SecurityException;

@Service
public class SecurityServiceImpl implements SecurityService {

    @Autowired
    private UserService userService;

    @Autowired
    private SessionCache sessionCache;

    private Integer checkCredentials(AuthRequestDTO authRequestDTO) {
        return userService.getUserByCredentials(authRequestDTO.getLogin(), authRequestDTO.getPassword()).getId();
    }

    @Override
    public AuthRequestDTO authUser(AuthRequestDTO authRequestDTO) {
        try {
            sessionCache.putUser(authRequestDTO, checkCredentials(authRequestDTO));
            authRequestDTO.setMessage("OK");
        } catch (Exception e) {
            throw new SecurityException("Wrong user/login");
        }
        return authRequestDTO;
    }

    @Override
    public boolean checkPermission(Integer userId) {
        return false;
    }
}
