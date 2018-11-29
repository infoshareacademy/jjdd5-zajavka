package com.infoshareacademy.zajavka.console;

import com.infoshareacademy.zajavka.Test;
import com.infoshareacademy.zajavka.data.Currency;
import com.infoshareacademy.zajavka.data.ListDirectoryException;
import com.infoshareacademy.zajavka.service.FileReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.ArrayList;
import java.util.List;

public class Menu {

    private static final Logger LOGGER = LoggerFactory.getLogger(Test.class);


        FileReader fileReader = new FileReader();
        List<Currency> currencyList = new ArrayList<>();

        try {
            currencyList = fileReader.getCurrenciesFromDirectory(dirPath);
        } catch (ListDirectoryException e) {
            LOGGER.error("Error, no currency: " + e.getMessage());
        }
    }





}
