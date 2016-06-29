package com.tarasiuk.movieland.cache;

import com.tarasiuk.movieland.dto.request.AuthRequestDTO;
import com.tarasiuk.movieland.entity.User;
import com.tarasiuk.movieland.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SessionCache {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private static final long SESSION_TIMEOUT = 2 * 60 * 60 * 1000;

    @Autowired
    private UserService userService;

    private final List<AuthRequestDTO> cacheList = Collections.synchronizedList(new ArrayList<>());

    public void putUser(AuthRequestDTO authRequestDTO, Integer userId) {
        if (!isUserInCache(userId)) {
            authRequestDTO.setUserId(userId);
            authRequestDTO.setPassword(null);
            authRequestDTO.setToken(UUID.randomUUID().toString());
            authRequestDTO.setLoginTimestamp(System.currentTimeMillis());
            cacheList.add(authRequestDTO);
            log.info("Put to cache token {} for userID {}", authRequestDTO.getToken(), userId);
        } else {
            authRequestDTO.setToken(getTokenByUserId(userId));
            log.info("Revert back token {} for existed userID {} from cache", authRequestDTO.getToken(), userId);
        }
    }

    public String getTokenByUserId (Integer userId) {
        for (AuthRequestDTO cache : cacheList) {
            if (cache.getUserId().equals(userId)) {
                return cache.getToken();
            }
        }
        return null;
    }

    public User getUserByToken (String token) {
        synchronized (cacheList) {
            for (AuthRequestDTO  cache : cacheList) {
                if (cache.getToken().equals(token) && cache.getLoginTimestamp() + SESSION_TIMEOUT > System.currentTimeMillis()) {
                    return userService.getUserById(cache.getUserId());
                } else {
                    cacheList.remove(cache);
                }
            }
        }
        return null;
    }

    public boolean isUserRoleByToken(String token, String[] roles) {
        for (String role : roles) {
            if (getUserByToken(token) != null && role.equals(getUserByToken(token).getRole())) {
                return true;
            }
        }
        return false;
    }

    public boolean isUserInCache (Integer userId) {
        for (AuthRequestDTO cache : cacheList) {
            if (cache.getUserId().equals(userId)) {
                return true;
            }
        }
        return false;
    }

    @Scheduled(fixedDelay = SESSION_TIMEOUT)
    public void cleanUpSessionPool(){
        synchronized (cacheList) {
            Iterator<AuthRequestDTO> iterator = cacheList.iterator();
            while (iterator.hasNext()) {
                AuthRequestDTO authRequestDTO = iterator.next();
                if (authRequestDTO.getLoginTimestamp() + SESSION_TIMEOUT> System.currentTimeMillis()) {
                    iterator.remove();
                }
            }
        }
    }
}
