package com.tarasiuk.movieland.service;

import com.tarasiuk.movieland.dto.NBUCurrencyRatesDTO;

import java.io.IOException;
import java.util.List;

public interface CurrencyRatesService {

    public List<NBUCurrencyRatesDTO> getCurrencyRatesList() throws IOException;

}
