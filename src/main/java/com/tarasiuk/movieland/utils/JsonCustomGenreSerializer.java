package com.tarasiuk.movieland.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.tarasiuk.movieland.entity.Genre;

import java.io.IOException;
import java.util.List;

public class JsonCustomGenreSerializer extends JsonSerializer<List<Genre>> {
    @Override
    public void serialize(List<Genre> genreList, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartArray();
        for (Genre genre : genreList) {
            jsonGenerator.writeString(genre.getGenre());
        }
        jsonGenerator.writeEndArray();
    }
}
