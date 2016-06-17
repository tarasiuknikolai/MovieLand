package com.tarasiuk.movieland.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.tarasiuk.movieland.entity.Review;

import java.io.IOException;
import java.util.List;

public class JsonCustomReviewSerializer extends JsonSerializer<List<Review>> {
    @Override
    public void serialize(List<Review> reviews, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartArray();
        for (Review g : reviews) jsonGenerator.writeString(g.getReview());
        jsonGenerator.writeEndArray();

   }
}
