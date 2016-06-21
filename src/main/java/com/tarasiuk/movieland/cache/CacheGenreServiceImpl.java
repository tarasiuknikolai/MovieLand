package com.tarasiuk.movieland.cache;

import com.tarasiuk.movieland.entity.Genre;
import com.tarasiuk.movieland.service.GenreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class CacheGenreServiceImpl implements InitializingBean {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private HashMapCacheService<Integer,Genre> cacheGenre;

    @Autowired
    private GenreService genreService;

    @Value("${cache.refreshPeriod:4}")
    private int refreshPeriod;

    private void fillCacheGenre() {
        log.info("Start warm-up the Cache for Genres");
        cacheGenre.clear();
        for (Genre genre : genreService.getAll()) {
            putValue(genre.getId(), genre);
        }
        log.info("Finish warm-up the Cache for Genres");
    }

    public Genre getById (int genreId) {
        Genre genre = cacheGenre.get(genreId);
        if (genre == null) {
            genre = genreService.getById(genreId);
            putValue(genre.getId(), genre);
        }
        return genre;
    }

    private void putValue(int genreId, Genre genre){
        cacheGenre.put(genreId, genre);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                fillCacheGenre();
            }
        }, 0, refreshPeriod, TimeUnit.HOURS);
    }
}
