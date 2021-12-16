package com.project.io;

import com.project.excel.CurrencyDocument;
import com.project.pojo.Currency;

import java.net.MalformedURLException;
import java.util.List;

public class CurrencyDocumentWriter {

    public static void writeCurrencyValuesToDocument(List<Currency> currencies, String docPath) {
        CurrencyDocument document = new CurrencyDocument();
        currencies.forEach(currency -> document.addCurrencyValue(currency.getDate(), currency));
        document.writeDocument(docPath);
    }
}
