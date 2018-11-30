package com.infoshareacademy.zajavka;

import com.infoshareacademy.zajavka.configuration.Configuration;
import com.infoshareacademy.zajavka.configuration.ReadConfiguration;
import com.infoshareacademy.zajavka.data.Currency;
import com.infoshareacademy.zajavka.data.ListDirectoryException;
import com.infoshareacademy.zajavka.service.FileReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

    private static final Logger LOGGER = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {

        if (args.length != 1) {
            LOGGER.error("Incorrect parameters provided");
            System.exit(1);
        }

        LOGGER.info("<<-- Run Crypto Analyzer apllication -->>");
        String dirPath = args[0];
        LOGGER.info("Data directory: {}", dirPath);

        List<Currency> currencyList = new ArrayList<>();
        LocalDate cDate;

        FileReader fileReader = new FileReader();
        try {
            currencyList = fileReader.getCurrenciesFromDirectory(dirPath);
        } catch (ListDirectoryException e) {
            LOGGER.error("Error, no currency: " + e.getMessage());
        }

        Configuration configuration = ReadConfiguration.loadProperties();

        for (Currency currency : currencyList) {
            System.out.println(getName(configuration, currency.getName()));
        }

        LocalDate startDate = readDateFromConsole("Please inserts the starting date of interval in format: RRRR-MM-DD");
        LOGGER.info("Starting date of interval " + startDate);
        LocalDate endDate = readDateFromConsole("Please inserts the end date of interval in format: RRRR-MM-DD");
        LOGGER.info("End date of interval " + endDate);

        System.out.println("Global max price: " + currencyList.get(1).maxPrice() + " USD");
        LOGGER.info("Global max price: " + currencyList.get(1).maxPrice() + " USD");
        System.out.println("Global min price: " + currencyList.get(1).minPrice() + " USD");
        LOGGER.info("Global max price: " + currencyList.get(1).minPrice() + " USD");

        System.out.println("Max price in interval: " + currencyList.get(1).maxPriceInDateRange(startDate, endDate) + " USD");
        LOGGER.info("Max price in interval: " + currencyList.get(1).maxPriceInDateRange(startDate, endDate) + " USD");
        System.out.println("Min price in interval: " + currencyList.get(1).minPriceInDateRange(startDate, endDate) + " USD");
        LOGGER.info("Min price in interval: " + currencyList.get(1).minPriceInDateRange(startDate, endDate) + " USD");

        while (true) {
            cDate = readDateFromConsole("Please inserts the date in correct format: RRRR-MM-DD");
            LOGGER.info("User insert the date " + cDate);
            for (Currency currency : currencyList) {
                System.out.println(getName(configuration, currency.getName()));
                System.out.println(currency.getDataForDate(cDate));
                LOGGER.info("Displaying data for " + currency.getName() + " " + currency.getDataForDate(cDate));
            }
        }

    }

    static String getName(Configuration configuration, String name) {
        String fullName = configuration.getNameCurrency(name);
        if (fullName == null) {
            return name.replaceAll(".csv", "");
        }
        return fullName;
    }

    static LocalDate readDateFromConsole(String statement) {
        System.out.println(statement);
        Scanner scanner = new Scanner(System.in);
        try {
            return LocalDate.parse(scanner.next());
        } catch (Exception e) {
            System.out.println("Incorrect format of date");
            LOGGER.error("Incorrect format of date: " + e.getMessage());
        }
        return readDateFromConsole(statement);
    }
}
