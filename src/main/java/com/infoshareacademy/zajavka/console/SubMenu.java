package com.infoshareacademy.zajavka.console;

import com.infoshareacademy.zajavka.data.Currency;

import java.time.LocalDate;
import java.util.NoSuchElementException;

import static com.infoshareacademy.zajavka.console.UserComunicator.PrintNElementsfromCurrencyList;

class SubMenu {
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
        switch (usersSubChoice) {
            case 1:
                printNewestPrice();
                if (UserComunicator.shouldContinue()) {
                    UserComunicator.clearScreen();
                    break;
                }
            case 2:
                printAllPrices();
                break;
            case 3:
                LocalDate date = UserComunicator.readDateFromConsole("Type date: (YYYY-MM-DD)");
                try {
                    printSelectedDay(date);
                    if (UserComunicator.shouldContinue()) {
                        UserComunicator.clearScreen();
                        break;
                    }
                } catch (NoSuchElementException e) {
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

    private void createLocalExtremes() {
        LocalDate startDate = UserComunicator.readDateFromConsole("Type start date: (YYYY-MM-DD)");
        LocalDate endDate = UserComunicator.readDateFromConsole("Type end date: (YYYY-MM-DD)");
        createLocalExtremes(startDate, endDate);
        if (UserComunicator.shouldContinue()) {
            UserComunicator.clearScreen();
        }
    }

    private void printNewestPrice() {
        System.out.println("Current price: " + currency.mostActualData().getDate() + " | " + currency.mostActualData().getPrice());
    }

    private void printAllPrices() {
        PrintNElementsfromCurrencyList(currency.getDailyDataList(), 10);
    }

    private void printSelectedDay(LocalDate date) {
        System.out.println(date + " | " + currency.selectedDayPrice(date) + " USD");
    }

    private void printGlobalExtremes() {
        System.out.println("Global minimum price: " + currency.minPrice() + " USD");
        System.out.println("Global minimum price: " + currency.maxPrice() + " USD");
    }

    private void createLocalExtremes(LocalDate startDateExtreme, LocalDate endDateExtreme) {
        System.out.println("Minimum price from " + startDateExtreme + " to " + endDateExtreme + ": "
                + currency.minPriceInDateRange(startDateExtreme, endDateExtreme) + " USD");
        System.out.println("Maximum price from " + startDateExtreme + " to " + endDateExtreme + ": "
                + currency.maxPriceInDateRange(startDateExtreme, endDateExtreme) + " USD");
    }
}