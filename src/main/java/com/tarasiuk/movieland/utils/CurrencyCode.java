package com.tarasiuk.movieland.utils;

public enum CurrencyCode {

    USD(840),
    EUR(978),
    UAH(980);

    private int numberCode;

    CurrencyCode(int numberCode) {
        this.numberCode = numberCode;
    }

    public static CurrencyCode getCurrencyCode(String charCode) {
        for (CurrencyCode currencyCode : CurrencyCode.values()) {
            if (currencyCode.name().equalsIgnoreCase(charCode.replace("\"",""))) {
                return currencyCode;
            }
        }
        throw new IllegalArgumentException("Illegal Currency Code");
    }

}
