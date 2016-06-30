package com.tarasiuk.movieland.cache;

import com.tarasiuk.movieland.entity.Genre;
import com.tarasiuk.movieland.service.GenreService;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class GenreCacheTest {

    private class StubGenreService implements GenreService {

        @Override
        public List<Genre> getAllForMovie(int movieId) {
            throw new UnsupportedOperationException();
        }

        @Override
        public List<Genre> getAll() {
            return new ArrayList<>(stubGenres.values());
        }

        @Override
        public Genre getById(int genreId) {
            return stubGenres.get(genreId);
        }
    }

    private Map<Integer, Genre> stubGenres = new ConcurrentHashMap<>();

    @Test
    public void test() throws Exception {
        HashMapCache<Integer, Genre> cacheService = new HashMapCache<>();
        //cacheService.put(1,new Genre());
        GenreCache cacheGenreService = new GenreCache();
        cacheGenreService.setRefreshPeriod(10);
        cacheGenreService.setRefreshTimeUnit(TimeUnit.SECONDS);
        cacheGenreService.setCache(cacheService);
        cacheGenreService.setGenreService(new StubGenreService());
        cacheGenreService.afterPropertiesSet();

        Genre genre1 = new Genre(1, "genre#1");

        Genre genre2 = new Genre(2, "genre#2");

        Genre genre3 = new Genre(3, "genre#3");

        cacheService.put(1, genre1);
        cacheService.put(2, genre2);
        cacheService.put(3, genre3);

        stubGenres.put(1, genre1);
        stubGenres.put(2, genre2);
        stubGenres.put(3, genre3);

        assertEquals(cacheService.get(1),stubGenres.get(1));
        assertNotEquals(cacheService.get(2),stubGenres.get(1));

    }
}
