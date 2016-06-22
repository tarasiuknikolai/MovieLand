package com.tarasiuk.movieland.controller;

import com.tarasiuk.movieland.dao.jdbc.JdbcUserDAO;
import com.tarasiuk.movieland.dto.request.AuthRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

@Controller
public class SecurityController {

    @Autowired
    private JdbcUserDAO userDao;

    @RequestMapping(value = "/v1/auth", consumes = "application/json;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> search(@RequestBody AuthRequestDTO authRequestDTO) {
        System.out.println(authRequestDTO);
        authRequestDTO.setToken(UUID.randomUUID().toString());
        authRequestDTO.setLoginTimestamp(System.currentTimeMillis());
        authRequestDTO.setUserId(userDao.getUserByCredentials(authRequestDTO.getLogin(),authRequestDTO.getPassword()).getId());

        return new ResponseEntity<>(authRequestDTO,HttpStatus.OK);
        //return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
