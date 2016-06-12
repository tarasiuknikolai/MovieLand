package com.tarasiuk.movieland.service.impl;

import com.tarasiuk.movieland.dao.CountryDAO;
import com.tarasiuk.movieland.entity.Country;
import com.tarasiuk.movieland.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryDAO countryDao;

    @Override
    public List<Country> getAllForMovie(int movieId) {
        return countryDao.getAllForMovie(movieId);
    }
}
