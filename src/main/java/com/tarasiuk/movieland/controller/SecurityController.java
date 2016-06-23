package com.tarasiuk.movieland.controller;

import com.tarasiuk.movieland.dto.request.AuthRequestDTO;
import com.tarasiuk.movieland.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.tarasiuk.movieland.service.exceptions.SecurityException;

@Controller
public class SecurityController {

    @Autowired
    private SecurityService securityService;

    @RequestMapping(value = "/v1/auth", consumes = "application/json;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> authentication (@RequestBody AuthRequestDTO authRequestDTO) {
        try {
            securityService.authUser(authRequestDTO);
        } catch (SecurityException e) {
            authRequestDTO.setMessage(e.getMessage());
            return new ResponseEntity<>(authRequestDTO, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(authRequestDTO,HttpStatus.OK);
    }

}
