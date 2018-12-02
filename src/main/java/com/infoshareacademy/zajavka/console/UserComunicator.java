package com.infoshareacademy.zajavka.console;

import com.infoshareacademy.zajavka.configuration.Configuration;
import com.infoshareacademy.zajavka.configuration.ReadConfiguration;
import com.infoshareacademy.zajavka.configuration.Configuration;
import com.infoshareacademy.zajavka.data.Currency;
import com.infoshareacademy.zajavka.data.CurrencyComparator;
import com.infoshareacademy.zajavka.data.DailyData;
import com.infoshareacademy.zajavka.service.FileReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static com.infoshareacademy.zajavka.configuration.ReadConfiguration.loadProperties;

class UserComunicator {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserComunicator.class);

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
                LOGGER.info("User choice to continue");
                return true;
            }
        } catch (Exception e) {
            System.out.println("Wrong intput:");
            LOGGER.warn("Wrong input from user about continue: " + sc);
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
                LOGGER.info("User input: " + choice);
                return intChoice;
            }
        } catch (Exception e) {
            if (choice.equals("q")) {
                LOGGER.info("User choice to exit");
                System.exit(0);
            }
            System.out.println("Wrong input.");
            LOGGER.warn("Wrong input from user when choice currency: " + choice);
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
                LOGGER.info("User choice to exit");
                System.exit(0);
            } else if (choice.equals("b")) {
                LOGGER.info("User back to choice currency menu");
                return 0;
            }
            System.out.println("Wrong input");
            LOGGER.warn("Wrong input from user in menu of currency: " + choice);
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
            LOGGER.warn("Incorrect format of date: " + e.getMessage());
        }
        return readDateFromConsole(statement);
    }

    static void PrintNElementsfromCurrencyList(List<DailyData> dailyData, Integer listNumbers) {
        Configuration configuration = loadProperties();
        String key;
        Integer n = 0;
        do {
            dailyData.stream().sorted(new CurrencyComparator()).skip(n * listNumbers).limit(listNumbers).forEach(dd -> System.out.println(dd.Date().format(configuration.getDateFormat()) + " " + configuration.getCharForSeparate() + " " + dd.getPriceUSD().setScale(configuration.getAmountNumberAfterSign(), BigDecimal.ROUND_HALF_DOWN).stripTrailingZeros() + " USD"));
            System.out.println("Press '+' to load more dates or '-' to back previous dates. Press 'b' to back to currency Menu");
            key = getInput();
            n += key.equals("+") && n * listNumbers <= dailyData.size() ? 1 : 0;
            n -= key.equals("-") && n * listNumbers >= listNumbers ? 1 : 0;
        } while (!key.equals("b"));
        LOGGER.info("User end watch list currency");

    }

    static void printMainMenu(List<Currency> currencyList) {
        System.out.println("To choose currency press number from 1 to " + currencyList.size());
        LOGGER.info("Number of found currency: " + currencyList.size());
        for (int i = 0; i < currencyList.size(); i++) {
            Configuration configuration = ReadConfiguration.loadProperties();
            System.out.println((i + 1) + " - " + getName(configuration, currencyList.get(i).getName()));
            LOGGER.info("Name of found currency: " + getName(configuration, currencyList.get(i).getName()));
        }
        System.out.println("Press 'q' to close program.");
    }

    static void printSubMenu(Currency currency) {
        Configuration configuration = ReadConfiguration.loadProperties();
        UserComunicator.clearScreen();
        LOGGER.info("Create menu from currency: " + getName(configuration, currency.getName()));
        System.out.println("Your currency: " + getName(configuration, currency.getName()));
        System.out.println(" ");
        System.out.println("1 - Current value.");
        System.out.println("2 - Exchange rate history.");
        System.out.println("3 - Value in selected day.");
        System.out.println("4 - Global extremes.");
        System.out.println("5 - Local extremes.");
        System.out.println(" ");
        System.out.println("Press 'q' to quit or 'b' to back to Main Menu");
    }

    static String getName(Configuration configuration, String name) {
        String fullName = configuration.getNameCurrency(name);
        if (fullName == null) {
            return name.replaceAll(".csv", "");
        }
        return fullName;
    }

}