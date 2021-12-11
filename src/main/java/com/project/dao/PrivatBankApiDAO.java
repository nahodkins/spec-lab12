package com.project.dao;

import com.project.pojo.Currency;
import com.project.pojo.ExchangeRates;

import javax.json.Json;
import javax.json.JsonReader;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

public class PrivatBankApiDAO {

    private static final String API_URL = " https://api.privatbank.ua/p24api/exchange_rates?json&date=%s";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    private static PrivatBankApiDAO instance;

    private PrivatBankApiDAO() {
    }

    public static PrivatBankApiDAO getInstance() {
        if (instance == null) {
            instance = new PrivatBankApiDAO();
        }
        return instance;
    }

    private String getJson(JsonReader reader) {
        return reader.read().toString();
    }

    public ExchangeRates getExchangeRates(LocalDate date) throws MalformedURLException {
        String dateFormat = DATE_FORMATTER.format(date);
        URL url = new URL(String.format(API_URL, dateFormat));
        try (JsonReader reader = Json.createReader(url.openStream())){
            Jsonb jsonb = JsonbBuilder.create();
            return jsonb.fromJson(getJson(reader), ExchangeRates.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Currency getCurrency(String currencyName, LocalDate date) throws MalformedURLException {
        return getExchangeRates(date).getExchangeRate().stream()
                .filter(currency -> currencyName.equals(currency.getCurrency()))
                .findFirst()
                .orElse(null);
    }
}
