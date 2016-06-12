package com.tarasiuk.movieland.service;

import java.util.List;
import com.tarasiuk.movieland.entity.Country;


public interface CountryService {

    List<Country> getAllForMovie(int movieId);

}
