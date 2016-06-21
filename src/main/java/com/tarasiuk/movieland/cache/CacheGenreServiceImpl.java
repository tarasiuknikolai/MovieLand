package com.tarasiuk.movieland.cache;

import com.tarasiuk.movieland.entity.Genre;
import com.tarasiuk.movieland.service.GenreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CacheGenreServiceImpl implements CacheGenreService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final Map<Integer, Genre> cacheGenre = new ConcurrentHashMap<>();

    private LocalDateTime lastRefreshDate;

    @Value("${cache.refreshPeriod:4}")
    private int refreshPeriod;

    @Autowired
    private GenreService genreService;

    private void fillCacheGenre() {
        log.info("Start warm-up the Cache for Genres");
        cacheGenre.clear();
        for (Genre genre : genreService.getAll()) {
            cacheGenre.put(genre.getId(), genre);
        }
        log.info("Stop warm-up the Cache for Genres");
    }

    @Override
    public Genre getById(int genreId) {
        log.info("Start get data from the Cache for Genres by ID");
        if (lastRefreshDate == null || LocalDateTime.now().isAfter(lastRefreshDate.plusHours(refreshPeriod))) {
            fillCacheGenre();
            lastRefreshDate = LocalDateTime.now();
        }
        Genre genre = cacheGenre.get(genreId);
        log.info("Stop get data from the Cache for Genres by ID");
        if (genre != null)
            return genre;
        throw new RuntimeException("Genre with id =" + genreId + " is missed in the Genre cache");
    }

}