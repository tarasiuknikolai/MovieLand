package com.tarasiuk.movieland.controller;

import com.tarasiuk.movieland.cache.SessionCache2;
import com.tarasiuk.movieland.dto.request.AuthRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Controller
public class SecurityController {

    @Autowired
    private SessionCache2 sessionCache;

    @RequestMapping(value = "/v1/auth", consumes = "application/json;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> authentication (@RequestBody AuthRequestDTO authRequestDTO) {
        authRequestDTO.setToken(UUID.randomUUID().toString());
        authRequestDTO.setLoginTimestamp(System.currentTimeMillis());
        if (sessionCache.checkCredentials(authRequestDTO) != null) {
            return new ResponseEntity<>(authRequestDTO,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
