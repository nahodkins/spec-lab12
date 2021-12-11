package com.project;

import com.project.io.CurrencyDocumentWriter;
import com.project.pojo.Currency;
import com.project.service.PrivatBankService;

import java.net.MalformedURLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws MalformedURLException {
        PrivatBankService service = PrivatBankService.getInstance();
        List<Currency> usd = service.getCurrencyValuesForPeriod("USD", 2020);
        CurrencyDocumentWriter.writeCurrencyValuesToDocument(usd, "currencies.xls");
    }
}
