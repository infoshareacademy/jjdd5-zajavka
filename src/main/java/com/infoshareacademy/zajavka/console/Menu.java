package com.infoshareacademy.zajavka.console;

import com.infoshareacademy.zajavka.data.Currency;

import java.util.ArrayList;
import java.util.List;

import static com.infoshareacademy.zajavka.console.UserComunicator.getInputFromUser;
import static com.infoshareacademy.zajavka.console.UserComunicator.validateInput;

public class Menu {

    //    List<Currency> = getCurrenciesFromDirectory;
        private String choice;



     /*   public static Currency chooseCurrency(List <Currency> listawalut){

            printMainMenu(listawalut);

            String choice = getInputFromUser();

            validateInput(choice);

            shouldCloseApplication(choice);

        }
*/
        public static void printMainMenu (List <Currency> listawalut) {
            System.out.println("To choose currancy press number from 1 to 9.");
            for (int i = 0; i < listawalut.size(); i++) {
                System.out.println(i + " - " + listawalut.get(i).getName());
            }
            System.out.println("To exit, press 'e'.");
        }

    public static void printCurrencyMenu() {



    }

    public static void shouldCloseApplication(String choice){
        if (choice.equals("e")) {
            System.exit(0);
        }
    }






}


