package com.tarasiuk.movieland.service;

import com.tarasiuk.movieland.dto.request.AuthRequestDTO;

public interface SecurityService {

    public AuthRequestDTO authUser(AuthRequestDTO authRequestDTO);
}
