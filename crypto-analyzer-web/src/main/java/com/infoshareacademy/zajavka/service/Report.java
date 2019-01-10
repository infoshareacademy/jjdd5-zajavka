package com.infoshareacademy.zajavka.service;

import com.infoshareacademy.zajavka.data.Currency;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Report {

    public List<Currency>  getCurrency (String currency){
        List<Currency> userCurrency = new ArrayList<>();


    }


    public void writingContent()
            throws IOException {
        String str = "Report for user";// tutaj tworze kontent
        BufferedWriter writer = new BufferedWriter(new FileWriter("fileName.txt"));
        writer.write(str);

        writer.close();
    }
}
