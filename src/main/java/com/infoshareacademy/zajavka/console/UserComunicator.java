package com.infoshareacademy.zajavka.console;

import java.util.Scanner;

public class UserComunicator {


    public static String getInputFromUser() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static Boolean validateInput(String choice) {

        boolean isValidChoice = false;

        switch (choice) {
            case "1":
                isValidChoice = true;
            case "2":
                isValidChoice = true;
            case "3":
                isValidChoice = true;
            case "4":
                isValidChoice = true;
            case "5":
                isValidChoice = true;
            case "6":
                isValidChoice = true;
            case "7":
                isValidChoice = true;
            case "8":
                isValidChoice = true;
            case "9":
                isValidChoice = true;
            case "b":
                isValidChoice = true;
            case "q":
                isValidChoice = true;
            default:
                isValidChoice = false;
        }
        return isValidChoice;
    }
}
