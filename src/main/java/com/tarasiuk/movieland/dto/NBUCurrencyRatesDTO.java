package com.tarasiuk.movieland.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NBUCurrencyRatesDTO {

    @JsonProperty(value = "r030")
    private int numberCode;

    @JsonProperty(value = "txt")
    private String name;

    private double rate;

    @JsonProperty(value = "cc")
    private String charCode;

    @JsonProperty(value = "exchangedate")
    private String exchangeDate;

    public int getNumberCode() {
        return numberCode;
    }

    public void setNumberCode(int numberCode) {
        this.numberCode = numberCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getCharCode() {
        return charCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public String getExchangeDate() {
        return exchangeDate;
    }

    public void setExchangeDate(String exchangeDate) {
        this.exchangeDate = exchangeDate;
    }

    @Override
    public String toString() {
        return "NBUCurrencyRatesDTO{" +
                "numberCode=" + numberCode +
                ", name='" + name + '\'' +
                ", rate=" + rate +
                ", charCode='" + charCode + '\'' +
                ", exchangeDate='" + exchangeDate + '\'' +
                '}';
    }
}
