package com.infoshareacademy.zajavka;

import com.infoshareacademy.zajavka.data.Currency;
import com.infoshareacademy.zajavka.data.ListDirectoryException;
import com.infoshareacademy.zajavka.service.FileReader;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Path dataFilePath = Paths.get("data");
        List<String> fileNames = new ArrayList<>();
        List<Currency> currencyList = new ArrayList<>();
        LocalDate cDate;

        FileReader fileReader = new FileReader();
        try {
            currencyList = fileReader.getCurrenciesFromDirectory();
        } catch (ListDirectoryException e) {
            e.printStackTrace();
        }

        for (Currency currency : currencyList) {
            System.out.println(currency.getName());
        }

        while (true) {
            cDate = readDateFromConsole();
            for (Currency currency : currencyList) {
                System.out.println(currency.getName());
                System.out.println(currency.getDataForDate(cDate));
            }
        }

    }

    static LocalDate readDateFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj date w formacie: rrrr-mm-dd");
        return LocalDate.parse(scanner.next());
    }
}
