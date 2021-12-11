package com.project.excel;

import com.project.pojo.Currency;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CurrencyDocument {

    private static final String DATE_CELL_NAME = "Date";
    private static final String CURRENCY_CELL_NAME = "Currency value";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    private HSSFWorkbook workbook;
    private HSSFSheet sheet;
    private Integer rowsNumber;

    public CurrencyDocument() {
        workbook = new HSSFWorkbook();
        sheet = workbook.createSheet();
        rowsNumber = 0;
    }

    private void addHeader() {
        HSSFRow row = sheet.createRow(rowsNumber++);
        row.createCell(0).setCellValue(DATE_CELL_NAME);
        row.createCell(1).setCellValue(CURRENCY_CELL_NAME);
    }

    public void addCurrencyValue(LocalDate date, Currency currency) {
        if (rowsNumber == 0) {
            addHeader();
        }
        HSSFRow row = sheet.createRow(rowsNumber++);
        row.createCell(0).setCellValue(FORMATTER.format(date));
        row.createCell(1).setCellValue(currency.getSaleRateNB());
    }

    public void writeDocument(String path) {
        try (FileOutputStream stream = new FileOutputStream(path)){
            workbook.write(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
