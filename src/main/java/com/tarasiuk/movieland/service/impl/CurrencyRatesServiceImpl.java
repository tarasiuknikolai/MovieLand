package com.tarasiuk.movieland.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tarasiuk.movieland.dto.NBUCurrencyRatesDTO;
import com.tarasiuk.movieland.service.CurrencyRatesService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class CurrencyRatesServiceImpl implements CurrencyRatesService {

    @Value("${url.currency.rates.nbu}")
    private  String url;

    @Override
    public List<NBUCurrencyRatesDTO> getCurrencyRatesList() throws IOException {
        URL currencyRatesUrl = new URL(url);
        URLConnection urlConnection = currencyRatesUrl.openConnection();
        ObjectMapper om = new ObjectMapper();
        return om.readValue(currencyRatesUrl, new TypeReference<List<NBUCurrencyRatesDTO>>(){});
    }
}
