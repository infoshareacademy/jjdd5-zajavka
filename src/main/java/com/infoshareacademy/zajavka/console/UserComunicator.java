package com.infoshareacademy.zajavka.console;

import com.infoshareacademy.zajavka.data.Currency;
import com.infoshareacademy.zajavka.service.FileReader;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UserComunicator {

    public static String getInputFromUser() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine().toLowerCase();
    }

    public static boolean validateUserInput(String choice, List<Currency> currencyList) {

        try {
                int number = Integer.parseInt(choice);
                if (number <= currencyList.size() && number < 0) {
                    return true;
                }
                System.out.println("Incorrect number");
                return false;

        } catch (NumberFormatException e) {
            if (choice.equals("q") || choice.equals("b")) {
                return true;
            }
            System.out.println("Incorrect number");
            return false;
        }
    }

    public static void printMenu(List<Currency> currencyList) {
        System.out.println("To choose currency press number from 1 to " + currencyList.size());
        for (int i = 0; i < currencyList.size(); i++) {
            System.out.println((i + 1) + " - " + currencyList.get(i).getName());
        }
        System.out.println("Press 'q' to close program.");
    }


    public static void printCurrencyMenu() {
        System.out.println("1 - Current exchange rate.");
        System.out.println("2 - Exchange rate history.");
        System.out.println("3 - Exchange rate in selected day");
        System.out.println("4 - Min and max value");
        System.out.println("5 - Min and max value in selected time range");
        System.out.println("");
        System.out.println("Press 'q' to quit or 'b' to back to Main Menu");
    }


}