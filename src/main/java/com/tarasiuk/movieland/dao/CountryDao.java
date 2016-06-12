package com.tarasiuk.movieland.dao;

import java.util.List;
import com.tarasiuk.movieland.entity.Country;

public interface CountryDAO {

    List<Country> getAllForMovie (int movieId);

}
