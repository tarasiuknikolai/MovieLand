package com.tarasiuk.movieland.cache;

import com.tarasiuk.movieland.dto.request.AuthRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.AbstractMap;

@Service
public class SessionCache {

    @Value("${session.timeout:2}")
    private int sessionTimeout;

    @Autowired
    ArrayListCache<String, AuthRequestDTO> sessionCache;

    public AuthRequestDTO getToken(String token){
        return sessionCache.get(token);
    }

    public void putToken(String token, AuthRequestDTO user){
        sessionCache.put(token,user);
    }

    @Scheduled(fixedDelay = 10 * 60 * 1000 )
    public void cleanUpSessionPool(){
        int[] toDelArray = new int[sessionCache.size()];
        for (int i = 0; i < sessionCache.size(); i++) {
            toDelArray[i] = sessionCache.get(i).getValue().getLoginTimestamp() > System.currentTimeMillis() ? 1 : 0;
        }
        for (int i = toDelArray.length-1; i>0 ; i-- ) {
            if (toDelArray[i] == 1) sessionCache.remove(sessionCache.get(i).getKey());
        }
    }

}