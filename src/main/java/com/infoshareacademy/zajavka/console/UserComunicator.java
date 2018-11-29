package com.infoshareacademy.zajavka.console;

import com.infoshareacademy.zajavka.data.Currency;
import com.infoshareacademy.zajavka.service.FileReader;

import java.util.List;
import java.util.Scanner;

public class UserComunicator {

    public static String getInputFromUser() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static boolean isInputNumber(String choice) {
        try {
            Integer.parseInt(choice);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static int convertInputToNumber(String input) {
        if (isInputNumber(input)) {
            int n = Integer.parseInt(input);
            if (n > 0) {
                return n;
            }
        } else if (input.compareTo("q") == 0) {
            return 0;
        }
        return -1;
    }


    public static void printMainMenu(List<Currency> currencyList) {
        Currency
    }

    public static void printChosenCurrencyMenu(String input, List<Currency> currencyList){
        int userChoiceAsNumber = convertInputToNumber(input);
        if((userChoiceAsNumber > 0) && (userChoiceAsNumber < currencyList.size())){

        }
}


}
