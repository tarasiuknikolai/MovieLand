package com.tarasiuk.movieland.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "movies")
public class MoviesListDTO {

    @JacksonXmlElementWrapper(localName = "movie", useWrapping = false)
    private List<MovieAllDTO> movie;

    public List<MovieAllDTO> getMovie() {
        return movie;
    }

    public void setMovies(List<MovieAllDTO> movie) {
        this.movie = movie;
    }
}
