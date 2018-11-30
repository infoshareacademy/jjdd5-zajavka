package com.infoshareacademy.zajavka.console;

import com.infoshareacademy.zajavka.data.Currency;
import com.infoshareacademy.zajavka.service.FileReader;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UserComunicator {

    public static String getInputFromUser(String statement) {
        System.out.println(statement);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine().toLowerCase();
    }


    static boolean validateDateFromUser(String date){
            try {
                LocalDate.parse(date);
                return true;
            }
            catch (DateTimeParseException e){
                return false;
            }
    }

    public static boolean validateMainMenuChoice(String choice, List<Currency> currencyList) {
        choice.toLowerCase();
        if (choice.equals("q")){
            return true;
        } else if (Integer.parseInt(choice) > 0 && Integer.parseInt(choice) <= currencyList.size()) {
            return true;
        } else return false;
    }

        /*        try {
            int number = Integer.parseInt(choice);
            if (number <= currencyList.size() && number > 0) {
                return number;
            }
            System.out.println("Incorrect number");
            return -1;

        } catch (NumberFormatException e) {
            if (choice.equals("q") || choice.equals("b")) {
                return 0;
            }
            System.out.println("Incorrect number");
            return -1;
        }*/



    public static boolean validateSubMenuChoice(String choice) {
        choice.toLowerCase();
        if (choice.equals("q") || choice.equals("b")) {
            return true;
        } else if (Integer.parseInt(choice) > 0 && Integer.parseInt(choice) <= 5) {
            return true;
        } else return false;
    }

    public static void printMainMenu(List<Currency> currencyList) {
        System.out.println("To choose currency press number from 1 to " + currencyList.size());
        for (int i = 0; i < currencyList.size(); i++) {
            System.out.println((i + 1) + " - " + currencyList.get(i).getName());
        }
        System.out.println("Press 'q' to close program.");
    }


    public static void printSubMenu() {
        System.out.println("1 - Current exchange rate.");
        System.out.println("2 - Exchange rate history.");
        System.out.println("3 - Exchange rate in selected day");
        System.out.println("4 - Min and max value");
        System.out.println("5 - Min and max value in selected time range");
        System.out.println("");
        System.out.println("Press 'q' to quit or 'b' to back to Main Menu");
    }

    public static void incorrectInputMessage() {
        System.out.println("Incorrect input, try again.");
    }

    public void printFirsOptionSubMenu(){

    }
}