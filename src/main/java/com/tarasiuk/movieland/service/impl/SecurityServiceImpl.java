package com.tarasiuk.movieland.service.impl;

import com.tarasiuk.movieland.cache.SessionCache2;
import com.tarasiuk.movieland.dto.request.AuthRequestDTO;
import com.tarasiuk.movieland.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SecurityServiceImpl implements SecurityService {

    @Autowired
    private SessionCache2 sessionCache;

    @Override
    public AuthRequestDTO authUser(AuthRequestDTO authRequestDTO) {
        sessionCache.putUser(authRequestDTO, sessionCache.checkCredentials(authRequestDTO));
        authRequestDTO.setMessage("OK");
        return authRequestDTO;
    }
}
