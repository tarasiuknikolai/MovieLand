package com.tarasiuk.movieland.service.security;

import com.tarasiuk.movieland.cache.SessionCache;
import com.tarasiuk.movieland.dao.RatingDAO;
import com.tarasiuk.movieland.entity.Movie;
import com.tarasiuk.movieland.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieSecurityService {

    @Autowired
    private MovieService movieService;

    @Autowired
    private SessionCache sessionCache;

    @Autowired
    private RatingDAO ratingDAO;

    public Movie getById(int id, String token) {
        Movie movie = movieService.getById(id);
        if (token != null && sessionCache.getUserByToken(token) != null) {
            movie.setRating(ratingDAO.getRatingByMovieIdAndUserId(id,sessionCache.getUserByToken(token).getId()).getRating());
        }
        return movie;
    }

}
