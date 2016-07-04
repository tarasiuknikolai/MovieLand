package com.tarasiuk.movieland.security;

import com.tarasiuk.movieland.cache.SessionCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecutiryService {

    @Autowired
    SessionCache sessionCache;

}
