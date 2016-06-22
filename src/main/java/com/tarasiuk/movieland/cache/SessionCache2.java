package com.tarasiuk.movieland.cache;

import com.tarasiuk.movieland.dto.request.AuthRequestDTO;
import com.tarasiuk.movieland.entity.User;
import com.tarasiuk.movieland.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@Service
public class SessionCache2 {

    private static final long SESSION_TIMEOUT = 2 * 60 * 60 * 1000;

    @Autowired
    private UserService userService;

    private final List<AuthRequestDTO> cacheList = Collections.synchronizedList(new ArrayList<>());

    public AuthRequestDTO checkCredentials(AuthRequestDTO authRequestDTO) {
        try {
            int userId=userService.getUserByCredentials(authRequestDTO.getLogin(),authRequestDTO.getPassword()).getId();
            if (userId != 0) {
                authRequestDTO.setUserId(userId);
                cacheList.add(authRequestDTO);
                return authRequestDTO;
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    public User getUserByToken (String token) {
        for (AuthRequestDTO  cache : cacheList) {
            if (cache.getToken().equals(token) && cache.getLoginTimestamp() + SESSION_TIMEOUT > System.currentTimeMillis()) {
                return userService.getUserById(cache.getUserId());
            } else {
                cacheList.remove(cache);
            }
        }
        return null;
    }

    @Scheduled(fixedDelay = SESSION_TIMEOUT)
    public void cleanUpSessionPool(){
        Iterator<AuthRequestDTO> iterator = cacheList.iterator();
        while (iterator.hasNext()) {
            AuthRequestDTO authRequestDTO = iterator.next();
            if (authRequestDTO.getLoginTimestamp() + SESSION_TIMEOUT> System.currentTimeMillis()) {
                iterator.remove();
            }
        }
    }
}
