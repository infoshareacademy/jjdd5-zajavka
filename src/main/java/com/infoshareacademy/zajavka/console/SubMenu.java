package com.infoshareacademy.zajavka.console;

import com.infoshareacademy.zajavka.configuration.Configuration;
import com.infoshareacademy.zajavka.configuration.ReadConfiguration;
import com.infoshareacademy.zajavka.data.Currency;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.NoSuchElementException;

import static com.infoshareacademy.zajavka.console.UserComunicator.PrintNElementsfromCurrencyList;
import static com.infoshareacademy.zajavka.console.UserComunicator.getName;

class SubMenu {
    private static final Logger LOGGER = LoggerFactory.getLogger(SubMenu.class);
    private boolean subMenuActive;
    private int usersSubChoice;
    private Currency currency;

    SubMenu(boolean subMenuActive, Currency currency) {
        this.subMenuActive = subMenuActive;
        this.currency = currency;
    }

    boolean isSubMenuActive() {
        return subMenuActive;
    }

    private void setSubMenuActive(boolean subMenuActive) {
        this.subMenuActive = subMenuActive;
    }

    void setUsersSubChoice(int usersSubChoice) {
        this.usersSubChoice = usersSubChoice;
    }

    Currency getCurrency() {
        return currency;
    }

    void createSubMenu() {
        Configuration configuration = ReadConfiguration.loadProperties();
        switch (usersSubChoice) {
            case 1:
                LOGGER.info("User choice to watch newest price " + getName(configuration, currency.getName()));
                printNewestPrice();
                if (UserComunicator.shouldContinue()) {
                    UserComunicator.clearScreen();
                    break;
                }
            case 2:
                LOGGER.info("User choice to print all price " + getName(configuration, currency.getName()));
                printAllPrices();
                break;
            case 3:
                LOGGER.info("User choice to watch price in selected day " + getName(configuration, currency.getName()));
                LocalDate date = UserComunicator.readDateFromConsole("Type date: (YYYY-MM-DD)");
                try {
                    LOGGER.info("User insert the date " + date);
                    printSelectedDay(date);
                    if (UserComunicator.shouldContinue()) {
                        UserComunicator.clearScreen();
                        break;
                    }
                } catch (NoSuchElementException e) {
                    // loggery
                    UserComunicator.printWrongSelectedDay();
                    break;
                }
            case 4:
                printGlobalExtremes();
                if (UserComunicator.shouldContinue()) {
                    UserComunicator.clearScreen();
                    break;
                }
            case 5:
                try {
                    //loggery
                    createLocalExtremes();
                    break;
                } catch (NoSuchElementException e) {
                    UserComunicator.printWrongLocalExtremes();
                    break;
                }
            case 0:
                setSubMenuActive(false);
                break;
        }

    }
        // Loggery tu będą
    private void createLocalExtremes() {
        LocalDate startDate = UserComunicator.readDateFromConsole("Type start date: (YYYY-MM-DD)");
        LocalDate endDate = UserComunicator.readDateFromConsole("Type end date: (YYYY-MM-DD)");
        createLocalExtremes(startDate, endDate);
        if (UserComunicator.shouldContinue()) {
            UserComunicator.clearScreen();
        }
    }

    private void printNewestPrice() {
        Configuration configuration = ReadConfiguration.loadProperties();
        LOGGER.info("Current price: " + currency.mostActualData().getDate().format(configuration.getDateFormat()) + " " + configuration.getCharForSeparate() + " " + currency.mostActualData().getPrice().setScale(configuration.getAmountNumberAfterSign(), BigDecimal.ROUND_HALF_DOWN).stripTrailingZeros());
        System.out.println("Current price: " + currency.mostActualData().getDate().format(configuration.getDateFormat()) + " " + configuration.getCharForSeparate() + " " + currency.mostActualData().getPrice().setScale(configuration.getAmountNumberAfterSign(), BigDecimal.ROUND_HALF_DOWN).stripTrailingZeros());
    }


    private void printAllPrices() {
        PrintNElementsfromCurrencyList(currency.getDailyDataList(), 10);
    }

    private void printSelectedDay(LocalDate date) {
        LOGGER.info("Price for selected day: " + currency.selectedDayPrice(date));
        System.out.println(date + " | " + currency.selectedDayPrice(date) + " USD");
    }

    private void printGlobalExtremes() {
        System.out.println("Global minimum price: " + currency.minPrice().stripTrailingZeros() + " USD");
        LOGGER.info("Global minimum price : " + currency.minPrice().stripTrailingZeros() + " USD");
        System.out.println("Global maximum price: " + currency.maxPrice().stripTrailingZeros() + " USD");
        LOGGER.info("Global maximum price : " + currency.maxPrice().stripTrailingZeros() + " USD");
    }

    private void createLocalExtremes(LocalDate startDateExtreme, LocalDate endDateExtreme) {
        System.out.println("Minimum price from " + startDateExtreme + " to " + endDateExtreme + ": "
                + currency.minPriceInDateRange(startDateExtreme, endDateExtreme).stripTrailingZeros() + " USD");
        LOGGER.info("Minimum price from " + startDateExtreme + " to " + endDateExtreme + ": " + currency.minPriceInDateRange(startDateExtreme, endDateExtreme).stripTrailingZeros() + " USD");
        System.out.println("Maximum price from " + startDateExtreme + " to " + endDateExtreme + ": "
                + currency.maxPriceInDateRange(startDateExtreme, endDateExtreme).stripTrailingZeros() + " USD");
        LOGGER.info("Minimum price from " + startDateExtreme + " to " + endDateExtreme + ": " + currency.maxPriceInDateRange(startDateExtreme, endDateExtreme).stripTrailingZeros() + " USD");
    }
}