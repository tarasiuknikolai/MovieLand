package com.tarasiuk.movieland.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.tarasiuk.movieland.entity.Country;

import java.io.IOException;
import java.util.List;

public class JsonCustomCountrySerializer  extends JsonSerializer<List<Country>> {
    @Override
    public void serialize(List<Country> countries, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartArray();
        for (Country c : countries) jsonGenerator.writeString(c.getCountry());
        jsonGenerator.writeEndArray();
    }
}
