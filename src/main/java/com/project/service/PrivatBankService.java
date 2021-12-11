package com.project.service;

import com.project.dao.PrivatBankApiDAO;
import com.project.pojo.Currency;
import com.project.pojo.ExchangeRates;

import java.net.MalformedURLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PrivatBankService {

    private PrivatBankApiDAO dao;
    private static PrivatBankService instance;

    private PrivatBankService() {
        dao = PrivatBankApiDAO.getInstance();
    }

    public static PrivatBankService getInstance() {
        if (instance == null) {
            instance = new PrivatBankService();
        }
        return instance;
    }

    public ExchangeRates getExchangeRates(LocalDate date) throws MalformedURLException {
        return dao.getExchangeRates(date);
    }

    public Currency getCurrencyValue(String currency, LocalDate date) throws MalformedURLException {
        return dao.getCurrency(currency, date);
    }

    public List<Currency> getCurrencyValuesForPeriod(String currency, int periodStartYear) throws MalformedURLException {
        LocalDate start = LocalDate.of(periodStartYear, 1, 1);
        LocalDate end = LocalDate.of(LocalDate.now().getYear(), 12, 1);
        List<Currency> currencies = new ArrayList<>();

        while (!start.isAfter(end)) {
            currencies.add(getCurrencyValue(currency, start).setDate(start));
            start = start.plusMonths(1);
        }
        return currencies;
    }
}
