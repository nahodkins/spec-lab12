package com.project.pojo;

import java.time.LocalDate;

public class Currency {

    private LocalDate date;
    private String currency;
    private double saleRateNB;

    public String getCurrency() {
        return currency;
    }

    public LocalDate getDate() {
        return date;
    }

    public Currency setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public Currency setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public double getSaleRateNB() {
        return saleRateNB;
    }

    public Currency setSaleRateNB(double saleRateNB) {
        this.saleRateNB = saleRateNB;
        return this;
    }

    @Override
    public String toString() {
        return "com.project.pojo.Currency{" +
                "currency='" + currency + '\'' +
                ", saleRateNB=" + saleRateNB +
                '}';
    }
}
