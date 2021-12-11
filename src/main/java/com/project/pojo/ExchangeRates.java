package com.project.pojo;

import java.util.List;

public class ExchangeRates {

    private String date;
    private List<Currency> exchangeRate;

    public String getDate() {
        return date;
    }

    public ExchangeRates setDate(String date) {
        this.date = date;
        return this;
    }

    public List<Currency> getExchangeRate() {
        return exchangeRate;
    }

    public ExchangeRates setExchangeRate(List<Currency> exchangeRate) {
        this.exchangeRate = exchangeRate;
        return this;
    }
}
