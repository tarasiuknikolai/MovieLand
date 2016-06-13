package com.tarasiuk.movieland.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tarasiuk.movieland.entity.Movie;
import com.tarasiuk.movieland.utils.gsonmapper.JsonAllMovies;
import com.tarasiuk.movieland.utils.gsonmapper.JsonMovieById;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JsonCustomConverter {
    private final Logger log = LoggerFactory.getLogger(getClass());

    final GsonBuilder gsonAllMovieBuilder = new GsonBuilder();
    final GsonBuilder gsonMovieByIdBuilder = new GsonBuilder();
    {
        gsonAllMovieBuilder.registerTypeAdapter(Movie.class, new JsonAllMovies());
    }
    {
        gsonMovieByIdBuilder.registerTypeAdapter(Movie.class, new JsonMovieById());
    }

    public String allMovieToJson(List<Movie> movieList) {
        log.info("start converting Movies List to Json");
        long startTime = System.currentTimeMillis();
        Gson gson = gsonAllMovieBuilder.create();
        String jSonMovies = gson.toJson(movieList);
        log.info("All movies converted to Json {} format, it took {} ms",jSonMovies, System.currentTimeMillis() - startTime);
        return jSonMovies;
    }

    public String movieInfoByIdToJson(Movie movie){
        log.info("Start converting Movie to Json");
        long startTime = System.currentTimeMillis();
        Gson gson = gsonMovieByIdBuilder.create();
        String jSonMovieById = gson.toJson(movie);
        log.info("Movie with name {} , is converted to JSON, it took {}", movie.getNameeng(), System.currentTimeMillis() - startTime);
        return jSonMovieById;
    }
}
