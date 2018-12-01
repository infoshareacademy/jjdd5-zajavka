package com.infoshareacademy.zajavka.console;

import com.infoshareacademy.zajavka.data.Currency;

import java.time.LocalDate;
import java.util.NoSuchElementException;

import static com.infoshareacademy.zajavka.console.UserComunicator.PrintNElementsfromCurrencyList;

public class SubMenu {
    private boolean subMenuActive;
    private int usersSubChoice;
    private Currency currency;


    /*public SubMenu(Currency currency) {
        this.currency = currency;
    }*/
    public SubMenu(boolean subMenuActive, Currency currency) {
        this.subMenuActive = subMenuActive;
        this.currency = currency;
//        this.usersChoice = usersChoice;
    }

    public boolean isSubMenuActive() {
        return subMenuActive;
    }

    public void setSubMenuActive(boolean subMenuActive) {
        this.subMenuActive = subMenuActive;
    }


    public void setUsersSubChoice(int usersSubChoice) {
        this.usersSubChoice = usersSubChoice;
    }

    public Currency getCurrency() {
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
                /*if (UserComunicator.shouldContinue()) {
                    UserComunicator.clearScreen();
                }*/
                break;
            case 3:
                    LocalDate date = UserComunicator.readDateFromConsole("Type date: (YYYY-MM-DD");
                    try {
                        printSelectedDay(date);
                        if (UserComunicator.shouldContinue()) {
                            UserComunicator.clearScreen();
                            break;
                        }
                    } catch (NoSuchElementException e) {
                        System.out.println("We do not have value for this date.");
                    }
            case 4:
                printGlobalExtremes();
                if (UserComunicator.shouldContinue()) {
                    UserComunicator.clearScreen();
                    break;
                }
            case 5:
                LocalDate startDate = UserComunicator.readDateFromConsole("Type start date: (YYYY-MM-DD)");
                LocalDate endDate = UserComunicator.readDateFromConsole("Type end date: (YYYY-MM-DD)");
                printLocalExtremes(startDate, endDate);
                if (UserComunicator.shouldContinue()) {
                    UserComunicator.clearScreen();
                    break;
                }
            case 0:
                setSubMenuActive(false);
                break;
        }
    }

    void printNewestPrice() {
        System.out.println("Most actual data: " + currency.mostActualData().getDate() + " | " + currency.mostActualData().getPrice());
    }

    void printAllPrices() {
        PrintNElementsfromCurrencyList(currency.getDailyDataList(), 10);
    }

    void printSelectedDay(LocalDate date) {
        try {
            System.out.println(currency.selectedDayPrice(date));
        } catch (NoSuchElementException e) {
            System.out.println("We do not have value for this date.");
            UserComunicator.readDateFromConsole("Try other date:");
        }
    }

    void printGlobalExtremes() {
        System.out.println(currency.minPrice());
        System.out.println(currency.maxPrice());
    }

    void printLocalExtremes(LocalDate startDateExtreme, LocalDate endDateExtreme) {
        System.out.println("Max price in range: " + currency.maxPriceInDateRange(startDateExtreme, endDateExtreme) + " USD");
        System.out.println("Min price in range: " + currency.minPriceInDateRange(startDateExtreme, endDateExtreme) + " USD");
    }
}