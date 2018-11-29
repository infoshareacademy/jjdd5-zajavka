package com.infoshareacademy.zajavka.console;


import com.infoshareacademy.zajavka.data.Currency;
import com.infoshareacademy.zajavka.data.ListDirectoryException;
import com.infoshareacademy.zajavka.service.FileReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Menu {

    private static final Logger LOGGER = LoggerFactory.getLogger(Menu.class);


    public static void main(String[] args) {

        createMenu(args[0]);

    }
        //1 - Current exchange rate.");
        //2 - Exchange rate history.");
        //3 - Exchange rate in selected day");
        //4 - Min and max value");
        //5 - Min and max value in selected time range"

    public static void createMenu(String args) {

        String choice;
        FileReader fileReader = new FileReader();
        List<Currency> currencyList = new ArrayList<>();
        try {
            currencyList = fileReader.getCurrenciesFromDirectory(args);
        } catch (ListDirectoryException e) {
            LOGGER.error("Error, no currency: " + e.getMessage());
        }


        sortCurrencyList(currencyList);

        UserComunicator.printMenu(currencyList);

        choice = UserComunicator.getInputFromUser();

        UserComunicator.validateUserInput(choice, currencyList);
        Menu.shouldCloseProgram(choice);

    }



/*    private static String getCurrentRate(int choice, List<Currency> currencyList){
        Currency currentCurrency = currencyList.get(choice);
        currentCurrency.getDailyDataList()

    }*/

    public static boolean shouldCloseProgram(String choice) {
        if (choice.equals("q")) {
            return true;
        }
        return false;
    }

    public static boolean shouldBackToMainMenu(String choice) {
        if (choice.equals("b")) {
            return true;
        }
        return false;
    }


    private static void sortCurrencyList(List<Currency> currencyList) {
        currencyList.stream()
                .sorted((o1, o2) -> o1.getName().compareTo(o2.getName()))
                .collect(Collectors.toList());
    }


}

