package com.infoshareacademy.zajavka.console;

import com.infoshareacademy.zajavka.configuration.Configuration;
import com.infoshareacademy.zajavka.configuration.ReadConfiguration;
import com.infoshareacademy.zajavka.data.Currency;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.NoSuchElementException;

import static com.infoshareacademy.zajavka.console.UserComunicator.PrintNElementsfromCurrencyList;
import static com.infoshareacademy.zajavka.console.UserComunicator.getName;

public class SubMenu {

    private static final Logger LOGGER = LoggerFactory.getLogger(SubMenu.class);

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
        Configuration configuration = ReadConfiguration.loadProperties();
        switch (usersSubChoice) {
            case 1:
                printNewestPrice();
                LOGGER.info("User choice to watch newest price " + getName(configuration, currency.getName()) );
                if (UserComunicator.shouldContinue()) {
                    UserComunicator.clearScreen();
                    break;
                }
            case 2:
                LOGGER.info("User choice to print all price " + getName(configuration, currency.getName()));
                printAllPrices();
                /*if (UserComunicator.shouldContinue()) {
                    UserComunicator.clearScreen();
                }*/
                break;
            case 3:
                LOGGER.info("User choice to watch price in selected day " + getName(configuration, currency.getName()));
                LocalDate date = UserComunicator.readDateFromConsole("Type date: (YYYY-MM-DD");
                try {
                    LOGGER.info("User insert the date " + date);
                    printSelectedDay(date);
                    if (UserComunicator.shouldContinue()) {
                        UserComunicator.clearScreen();
                        break;
                    }
                } catch (NoSuchElementException e) {
                    LOGGER.info("We do not have value for this date: " + e.getMessage());
                    System.out.println("We do not have value for this date.");
                }
            case 4:
                LOGGER.info("User choice to print global extremes " + getName(configuration, currency.getName()));
                printGlobalExtremes();
                if (UserComunicator.shouldContinue()) {
                    UserComunicator.clearScreen();
                    break;
                }
            case 5:
                LOGGER.info("User choice to print extremes from selected time range " + getName(configuration, currency.getName()));
                LocalDate startDate = UserComunicator.readDateFromConsole("Type start date: (YYYY-MM-DD)");
                LocalDate endDate = UserComunicator.readDateFromConsole("Type end date: (YYYY-MM-DD)");
                LOGGER.info("Start date: " + startDate + " End date: " + endDate);
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
        Configuration configuration = ReadConfiguration.loadProperties();
        LOGGER.info("Most actual date: "+ currency.mostActualData().getDate().format(configuration.getDateFormat()) + " " + configuration.getCharForSeparate() + " " + currency.mostActualData().getPrice());
        System.out.println("Most actual date: " + currency.mostActualData().getDate().format(configuration.getDateFormat()) + " " + configuration.getCharForSeparate() + " " + currency.mostActualData().getPrice());
    }

    void printAllPrices() {
        PrintNElementsfromCurrencyList(currency.getDailyDataList(), 10);
    }

    void printSelectedDay(LocalDate date) {
        try {
            LOGGER.info("Price for selected day: "+currency.selectedDayPrice(date));
            System.out.println(currency.selectedDayPrice(date));
        } catch (NoSuchElementException e) {
            System.out.println("We do not have value for this date.");
            UserComunicator.readDateFromConsole("Try other date:");
        }
    }

    void printGlobalExtremes() {
        System.out.println("Min price : " + currency.minPrice());
        System.out.println("Max price : " + currency.maxPrice());
    }

    void printLocalExtremes(LocalDate startDateExtreme, LocalDate endDateExtreme) {
        System.out.println("Max price in range: " + currency.maxPriceInDateRange(startDateExtreme, endDateExtreme) + " USD");
        System.out.println("Min price in range: " + currency.minPriceInDateRange(startDateExtreme, endDateExtreme) + " USD");
    }
}