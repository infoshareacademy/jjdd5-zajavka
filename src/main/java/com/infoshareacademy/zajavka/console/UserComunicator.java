package com.infoshareacademy.zajavka.console;

import com.infoshareacademy.zajavka.data.Currency;
import com.infoshareacademy.zajavka.data.CurrencyComparator;
import com.infoshareacademy.zajavka.data.DailyData;
import com.infoshareacademy.zajavka.service.FileReader;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UserComunicator {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static boolean shouldContinue(){
        System.out.println("Press 'c' to continue.");
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine().toLowerCase();
        try {
            if(choice.equals("c")){
                return true;
            }
        }
        catch (Exception e){
            System.out.println("Wrong intput:");
        }
        return shouldContinue();
    }

    public static int getInputFromUser(List<Currency> currencyList, String statement) {
        System.out.println(statement);
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine().toLowerCase();
        try {
            int intChoice = Integer.parseInt(choice);
            if(intChoice > 0 && intChoice <= currencyList.size()){
                return intChoice;
            }
        }
        catch (Exception e){
            if (choice.equals("q")) {
                System.exit(0);
            }
            System.out.println("Wrong input.");
        }
        return getInputFromUser(currencyList,statement);
    }
    public static int getSubMenuInputFromUser(String statement) {
        System.out.println(statement);
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine().toLowerCase();
        try {
            return Integer.parseInt(choice);
        }
        catch (Exception e){
            if (choice.equals("q")) {
                System.exit(0);
            }
            else if (choice.equals("b")){
                return 0;
            }
            System.out.println("Wrong input");
        }
        return getSubMenuInputFromUser(statement);
    }

    public static LocalDate readDateFromConsole(String statement) {
        System.out.println(statement);
        Scanner scanner = new Scanner(System.in);
        try {
            return LocalDate.parse(scanner.next());
        } catch (Exception e) {
            UserComunicator.clearScreen();
            System.out.println("Incorrect format of date. Should be (YYYY-MM-DD");
         //   LOGGER.error("Incorrect format of date: " + e.getMessage());
        }
        return readDateFromConsole(statement);
    }

    public static void PrintNElementsfromCurrencyList(List<DailyData> dailyData, Integer listNumbers) {
        String key;
        Integer n = 0;
        do {
            dailyData.stream().sorted(new CurrencyComparator()).skip(n * listNumbers).limit(listNumbers).forEach(dd -> System.out.println(dd.Date() + " | " + dd.getPriceUSD() + " USD"));
            System.out.println("Press 'b' to back to currency Menu");
            key = GetKey();
            n += key.equals("+") && n*listNumbers<=dailyData.size() ? 1 : 0;
            n -= key.equals("-") && n*listNumbers>=listNumbers ? 1 : 0;
            System.out.println("Press 'b' to back to currency Menu");
        } while (!key.equals("b"));

    }

    public static String GetKey() {

        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public static void printMainMenu(List<Currency> currencyList) {
        System.out.println("To choose currency press number from 1 to " + currencyList.size());
        for (int i = 0; i < currencyList.size(); i++) {
            System.out.println((i + 1) + " - " + currencyList.get(i).getName());
        }
        System.out.println("Press 'q' to close program.");
    }

    public static void printSubMenu(Currency currency) {
        UserComunicator.clearScreen();
        System.out.println("Your currency: " + currency.getName());
        System.out.println("1 - Actual value.");
        System.out.println("2 - Exchange rate history.");
        System.out.println("3 - Value in selected day");
        System.out.println("4 - Min and max value");
        System.out.println("5 - Min and max value in selected time range");
        System.out.println("");
        System.out.println("Press 'q' to quit or 'b' to back to Main Menu");
    }

/*


    public static boolean validateMainMenuChoice(String choice, List<Currency> currencyList) {
        choice.toLowerCase();
        if (choice.equals("q")){
            return true;
        } else if (Integer.parseInt(choice) > 0 && Integer.parseInt(choice) <= currencyList.size()) {
            return true;
        } else return false;
    }*/

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



/*    public static boolean validateSubMenuChoice(String choice) {
        choice.toLowerCase();
        if (choice.equals("q") || choice.equals("b")) {
            return true;
        } else if (Integer.parseInt(choice) > 0 && Integer.parseInt(choice) <= 5) {
            return true;
        } else return false;
    }*/


    public static void incorrectInputMessage() {
        System.out.println("Incorrect input, try again.");
    }

    public void printFirsOptionSubMenu(){

    }
}