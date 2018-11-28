package com.infoshareacademy.zajavka;

import com.infoshareacademy.zajavka.data.Currency;
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

        fileNames = FileReader.listFilesForFolder(dataFilePath);

        LOGGER.info("Downloaded data from files " + fileNames);

        for (int i = 0; i < fileNames.size(); i++) {
            currencyList.add(new Currency(fileNames.get(i)));

            Path filePathWithName = Paths.get("data", fileNames.get(i));
            List<String> lines = FileReader.readFile(filePathWithName);

            for (int j = 1; j < lines.size(); j++) {
                currencyList.get(i).addDailyData(lines.get(j).split(","));
            }
        }


        for (Currency currency : currencyList) {
            System.out.println(currency.getName());
        }

        // dodanie wartosci ekstremalnych w przedziale czasowym
        LocalDate startDate = readDateFromConsole("Please insert the starting date of interval in format: RRRR-MM-DD");
        LocalDate endDate = readDateFromConsole("Please insert the end date of interval in format: RRRR-MM-DD");

        // ekstrema globalne
        System.out.println("Global max price: "+currencyList.get(1).maxPrice()+" USD");
        System.out.println("Global min price: "+currencyList.get(1).minPrice()+" USD");
        //  ekstrema w przedziale czasowym
      //  System.out.println(currencyList.get(1).maxPriceInDateRange());
        System.out.println("Max price in interval: "+currencyList.get(1).maxPriceInDateRange(startDate,endDate)+" USD");
        System.out.println("Min price in interval: "+currencyList.get(1).minPriceInDateRange(startDate,endDate)+" USD");
       // System.out.println(currencyList.get(1).minPriceInDateRange());

        while (true) {
            cDate = readDateFromConsole("Please insert the date in correct format: RRRR-MM-DD");
            LOGGER.info("User insert the date " + cDate);
            for (Currency currency : currencyList) {
                System.out.println(currency.getName());
                System.out.println(currency.getDataForDate(cDate));
                LOGGER.info("Displaying data for " + currency.getName() + " " + currency.getDataForDate(cDate));
            }
        }

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
