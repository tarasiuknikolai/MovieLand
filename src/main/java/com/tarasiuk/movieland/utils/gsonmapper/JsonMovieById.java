package com.tarasiuk.movieland.utils.gsonmapper;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.tarasiuk.movieland.entity.Country;
import com.tarasiuk.movieland.entity.Genre;
import com.tarasiuk.movieland.entity.Movie;
import com.tarasiuk.movieland.entity.Review;

import java.io.IOException;

public class JsonMovieById extends TypeAdapter<Movie> {

    @Override
    public void write(JsonWriter out, Movie movie) throws IOException {
        out.beginObject();
        out.name("namerus").value(movie.getNameRus());
        out.name("nameorigin").value(movie.getNameOrigin());
        out.name("year").value(movie.getYear());
        out.name("countries");
        out.beginArray();
        for (Country country : movie.getCountry()){
            out.value(country.getCountry());
        }
        out.endArray();
        out.name("genres");
        out.beginArray();
        for (Genre genre : movie.getGenre()) {
            out.value(genre.getGenre());
        }
        out.endArray();
        out.name("reviews");
        out.beginArray();
        for (Review review : movie.getReview()) {
            out.value(review.getReview());
        }
        out.endArray();
        out.name("rating").value(movie.getRating());
        out.endObject();
    }

    @Override
    public Movie read(JsonReader jsonReader) throws IOException {
        return null;
    }
}
