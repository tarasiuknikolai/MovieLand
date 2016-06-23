package com.tarasiuk.movieland.cache;

import com.tarasiuk.movieland.dto.request.AuthRequestDTO;
import com.tarasiuk.movieland.entity.User;
import com.tarasiuk.movieland.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SessionCache2 {

    private static final long SESSION_TIMEOUT = 2 * 60 * 60 * 1000;

    @Autowired
    private UserService userService;

    private final List<AuthRequestDTO> cacheList = Collections.synchronizedList(new ArrayList<>());

    public int checkCredentials(AuthRequestDTO authRequestDTO) {
        return userService.getUserByCredentials(authRequestDTO.getLogin(), authRequestDTO.getPassword()).getId();
    }

    public void putUser (AuthRequestDTO authRequestDTO, int userId) {
        authRequestDTO.setUserId(userId);
        authRequestDTO.setPassword(null);
        authRequestDTO.setToken(UUID.randomUUID().toString());
        authRequestDTO.setLoginTimestamp(System.currentTimeMillis());
        cacheList.add(authRequestDTO);
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
