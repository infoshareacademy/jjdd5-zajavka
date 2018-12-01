package com.infoshareacademy.zajavka.console;

import com.infoshareacademy.zajavka.data.Currency;

import java.time.LocalDate;

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

    public int getUsersSubChoice() {
        return usersSubChoice;
    }

    public void setUsersSubChoice(int usersSubChoice){
        this.usersSubChoice = usersSubChoice;
    }

    public Currency getCurrency() {
        return currency;
    }

    //public void setSubMenuActive(boolean subMenuActive) {
   //     this.subMenuActive = subMenuActive;
    //}

    void createSubMenu(){
        switch (usersSubChoice){
            case 1:
                printNewestPrice();
                break;
            case 2:
                printAllPrices();
                break;
            case 3:
                LocalDate date = UserComunicator.readDateFromConsole("Type date: (YYYY-MM-DD");
                printSelectedDay(date);
                break;
            case 4:
                printGlobalExtremes();
                break;
            case 5:
                LocalDate startDate = UserComunicator.readDateFromConsole("Type start date: (YYYY-MM-DD");
                LocalDate endDate = UserComunicator.readDateFromConsole("Type end date: (YYYY-MM-DD");
                printLocalExtremes(startDate,endDate);
                break;
            case 0:
                setSubMenuActive(false);
                break;
        }
    }



    void printNewestPrice() {
        System.out.println(currency);
    }

    void printAllPrices(){
        System.out.println(currency);
    }

    void printSelectedDay(LocalDate date){
        System.out.println(currency.selectedDayPrice(date));
    }

    void printGlobalExtremes(){
        System.out.println(currency.minPrice());
        System.out.println(currency.maxPrice());
    }

    void printLocalExtremes(LocalDate startDateExtreme, LocalDate endDateExtreme){
        System.out.println("Max price in range: " + currency.maxPriceInDateRange(startDateExtreme,endDateExtreme) + " USD");
        System.out.println("Min price in range: " + currency.minPriceInDateRange(startDateExtreme,endDateExtreme) + " USD");
    }



}