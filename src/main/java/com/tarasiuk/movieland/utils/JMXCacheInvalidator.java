package com.tarasiuk.movieland.utils;

import com.tarasiuk.movieland.cache.GenreCache;
import com.tarasiuk.movieland.cache.SessionCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

@Component
@ManagedResource(objectName = "MovieLand:name=InvalidateCache", description = "JMX Cache Invalidator bean")
public class JMXCacheInvalidator {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private SessionCache sessionCache;

    @Autowired
    private GenreCache genreCache;

    @ManagedOperation(description = "Invalidate Session Cache")
    public void invalidateSessionCache() {
        sessionCache.invalidateCache();
        log.info("Session cache is invalidated");
    }

    @ManagedOperation(description = "Invalidate Genres Cache")
    public void invalidateGenreCache() {
        genreCache.invalidateCache();
        log.info("Genre cache is invalidated");
    }

}
