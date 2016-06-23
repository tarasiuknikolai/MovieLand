package com.tarasiuk.movieland.service;

import com.tarasiuk.movieland.dto.request.AuthRequestDTO;
import com.tarasiuk.movieland.service.exceptions.RestrictAccessException;
import com.tarasiuk.movieland.service.exceptions.SecurityException;

public interface SecurityService {

    AuthRequestDTO authUser(AuthRequestDTO authRequestDTO) throws SecurityException;

    boolean checkPermission(Integer userId) throws RestrictAccessException;

}
