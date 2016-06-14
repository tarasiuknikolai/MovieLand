package com.tarasiuk.movieland.utils.gsonmapper;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.tarasiuk.movieland.entity.Genre;
import com.tarasiuk.movieland.entity.Movie;

import java.io.IOException;

public class JsonAllMovies  extends TypeAdapter<Movie> {
    @Override
    public void write(JsonWriter out, Movie movie) throws IOException {
        out.beginObject();
        out.name("namerus").value(movie.getNameRus());
        out.name("nameeng").value(movie.getNameOrigin());
        out.name("year").value(movie.getYear());
        out.name("rating").value(movie.getRating());
        out.name("genres");
        out.beginArray();
        for (Genre genre : movie.getGenre()) {
            out.value(genre.getGenre());
        }
        out.endArray();
        out.endObject();
    }

    @Override
    public Movie read(JsonReader jsonReader) throws IOException {
        return null;
    }
}
