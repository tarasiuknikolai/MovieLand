package com.tarasiuk.movieland.cache;

import com.tarasiuk.movieland.dto.NBUCurrencyRatesDTO;
import com.tarasiuk.movieland.service.CurrencyRatesService;
import com.tarasiuk.movieland.utils.CurrencyCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CurrencyRatesCache {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final List<NBUCurrencyRatesDTO> cacheList = Collections.synchronizedList(new ArrayList<>());

    @Autowired
    private CurrencyRatesService currencyRatesService;

    public NBUCurrencyRatesDTO getCurrencyRateByCharCode(String currencyCode) {
        for (NBUCurrencyRatesDTO cache : cacheList) {
            if (CurrencyCode.getCurrencyCode(cache.getCharCode())==CurrencyCode.getCurrencyCode(currencyCode)) {
                return cache;
            }
        }
        return null;
    }

    public void fillCache(List<NBUCurrencyRatesDTO> currencyRatesList) {
        for (NBUCurrencyRatesDTO nbu : currencyRatesList) {
            if (nbu.getNumberCode() == 980 || nbu.getNumberCode() == 840 || nbu.getNumberCode() == 978) {
                cacheList.add(nbu);
                //System.out.println(LocalDate.parse(nbu.getExchangeDate(), DateTimeFormatter.ofPattern("dd.MM.yyyy")));
            }
        }
    }

    @PostConstruct
    public void initCache() throws IOException {
        fillCache(currencyRatesService.getCurrencyRatesList());
    }

    @Scheduled(cron = "0 0 0 * * ?")
    public void refreshCache() throws IOException {
        synchronized (cacheList) {
            cacheList.clear();
        }
        initCache();
    }

}
