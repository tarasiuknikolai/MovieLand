package com.tarasiuk.movieland.service;

import com.tarasiuk.movieland.entity.Movie;
import java.util.List;

public interface MovieService {

    List<Movie> getAll(String ratingOrder, String priceOrder);

    Movie getById(int id);

}
