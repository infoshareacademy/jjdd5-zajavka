package com.infoshareacademy.zajavka;

import com.infoshareacademy.zajavka.data.Currency;
import com.infoshareacademy.zajavka.data.ListDirectoryException;
import com.infoshareacademy.zajavka.service.FileReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

    private static final Logger LOGGER = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {
        LOGGER.info("<<-- Run Crypto Analyzer apllication -->>");
        Path dataFilePath = Paths.get("data");
        List<String> fileNames = new ArrayList<>();
        List<Currency> currencyList = new ArrayList<>();
        LocalDate cDate;

        FileReader fileReader = new FileReader();
        try {
            currencyList = fileReader.getCurrenciesFromDirectory();
        } catch (ListDirectoryException e) {
            LOGGER.error(e.getMessage());
            LOGGER.error("Error, no currency");
        }

        for (Currency currency : currencyList) {
            System.out.println(currency.getName());
        }

        while (true) {
            cDate = readDateFromConsole();
            LOGGER.info("User insert the date " + cDate);
            for (Currency currency : currencyList) {
                System.out.println(currency.getName());
                System.out.println(currency.getDataForDate(cDate));
                LOGGER.info("Displaying data for " + currency.getName() + " " + currency.getDataForDate(cDate));
            }
        }

    }

    static LocalDate readDateFromConsole() {
        System.out.println("Please insert the date in correct format: RRRR-MM-DD");
        Scanner scanner = new Scanner(System.in);
        try {
            return LocalDate.parse(scanner.next());
        } catch (Exception e) {
            System.out.println("Incorrect format of date");
            LOGGER.error("Incorrect format of date: " + e.getMessage());
        }
        return readDateFromConsole();
    }
}
