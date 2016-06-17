package com.tarasiuk.movieland.dao;

import java.util.List;
import com.tarasiuk.movieland.entity.Movie;

public interface MovieDAO {

    List<Movie> getAll();

    List<Movie> getAll(String ratingOrder, String priceOrder);

    Movie getById(int id);

}
