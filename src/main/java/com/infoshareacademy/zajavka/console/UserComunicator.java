package com.infoshareacademy.zajavka.console;

import com.infoshareacademy.zajavka.data.Currency;
import com.infoshareacademy.zajavka.data.CurrencyComparator;
import com.infoshareacademy.zajavka.data.DailyData;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

class UserComunicator {

    static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static boolean shouldContinue() {
        System.out.println(" ");
        System.out.println("Press 'b' to previous window.");
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine().toLowerCase();
        try {
            if (choice.equals("b")) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Wrong intput:");
        }
        return shouldContinue();
    }

    private static String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    static int getInputFromUser(List<Currency> currencyList, String statement) {
        System.out.println(statement);
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine().toLowerCase();
        try {
            int intChoice = Integer.parseInt(choice);
            if (intChoice > 0 && intChoice <= currencyList.size()) {
                return intChoice;
            }
        } catch (Exception e) {
            if (choice.equals("q")) {
                System.exit(0);
            }
            System.out.println("Wrong input.");
        }
        return getInputFromUser(currencyList, statement);
    }

    static int getSubMenuInputFromUser(String statement) {
        System.out.println(statement);
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine().toLowerCase();
        try {
            return Integer.parseInt(choice);
        } catch (Exception e) {
            if (choice.equals("q")) {
                System.exit(0);
            } else if (choice.equals("b")) {
                return 0;
            }
            System.out.println("Wrong input");
        }
        return getSubMenuInputFromUser(statement);
    }

    static LocalDate readDateFromConsole(String statement) {
        System.out.println(statement);
        Scanner scanner = new Scanner(System.in);
        try {
            return LocalDate.parse(scanner.next());
        } catch (Exception e) {
            UserComunicator.clearScreen();
            System.out.println("Incorrect format of date. Should be (YYYY-MM-DD)");
        }
        return readDateFromConsole(statement);
    }

    static void PrintNElementsfromCurrencyList(List<DailyData> dailyData, Integer listNumbers) {
        String key;
        Integer n = 0;
        do {
            dailyData.stream().sorted(new CurrencyComparator()).skip(n * listNumbers).limit(listNumbers).forEach(dd -> System.out.println(dd.Date() + " | " + dd.getPriceUSD() + " USD"));
            System.out.println("Press '+' to load more dates or '-' to back previous dates. Press 'b' to back to currency Menu");
            key = getInput();
            n += key.equals("+") && n * listNumbers <= dailyData.size() ? 1 : 0;
            n -= key.equals("-") && n * listNumbers >= listNumbers ? 1 : 0;
        } while (!key.equals("b"));

    }

    static void printMainMenu(List<Currency> currencyList) {
        System.out.println("To choose currency press number from 1 to " + currencyList.size());
        for (int i = 0; i < currencyList.size(); i++) {
            System.out.println((i + 1) + " - " + currencyList.get(i).getName());
        }
        System.out.println("Press 'q' to close program.");
    }

    static void printSubMenu(Currency currency) {
        UserComunicator.clearScreen();
        System.out.println("Your currency: " + currency.getName());
        System.out.println(" ");
        System.out.println("1 - Current value.");
        System.out.println("2 - Exchange rate history.");
        System.out.println("3 - Value in selected day.");
        System.out.println("4 - Global extremes.");
        System.out.println("5 - Local extremes.");
        System.out.println(" ");
        System.out.println("Press 'q' to quit or 'b' to back to Main Menu");
    }


    static void printWrongLocalExtremes() {
        System.out.println("Sorry, we do not have value for this time range.");
        if (UserComunicator.shouldContinue()) {
            UserComunicator.clearScreen();
        }
    }

    static void printWrongSelectedDay(){
        System.out.println("Sorry, we do not have value for this date.");
        System.out.println(" ");
        if (UserComunicator.shouldContinue()) {
            UserComunicator.clearScreen();}
    }

}