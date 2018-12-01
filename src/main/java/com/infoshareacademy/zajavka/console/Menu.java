package com.infoshareacademy.zajavka.console;


import com.infoshareacademy.zajavka.data.Currency;
import com.infoshareacademy.zajavka.data.ListDirectoryException;
import com.infoshareacademy.zajavka.service.FileReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Menu {
    private static final Logger LOGGER = LoggerFactory.getLogger(Menu.class);

    public static void createMainMenu(String dirPath) {
        List<Currency> currencyList = new ArrayList<>();
        FileReader fileReader = new FileReader();
        try {
            currencyList = fileReader.getCurrenciesFromDirectory(dirPath);
        } catch (ListDirectoryException e) {
            LOGGER.error("Error, no currency: " + e.getMessage());
        }
        while (true) {
            UserComunicator.printMainMenu(currencyList);
            int usersChoice = UserComunicator.getInputFromUser(currencyList,"Enter: ");
            SubMenu subMenu = new SubMenu(true, currencyList.get(usersChoice - 1));
            while (subMenu.isSubMenuActive()) {
                UserComunicator.clearScreen();
                UserComunicator.printSubMenu(subMenu.getCurrency());
                int usersSubChoice = UserComunicator.getSubMenuInputFromUser("Enter: ");
                subMenu.setUsersSubChoice(usersSubChoice);
                subMenu.createSubMenu();
            }
        }
    }
}















        /*boolean shouldMainMenuActive = true;
        boolean shouldCloseApp = false;
        boolean shouldSubMenuActive = true;
        boolean isMainInputCorrect = false;
        boolean isSubInputCorrect = false;
        boolean isDateCorrect = false;
        boolean isLastInputCorrect = false;
        String choice = "";
        String subMenuChoice = "";
        String dateFromUser = "";
        int choiceToInt;
        Currency chosenCurrency;
        List<Currency> currencyList = new ArrayList<>();
        try {
            currencyList = fileReader.getCurrenciesFromDirectory(args);
        } catch (ListDirectoryException e) {
            LOGGER.error("Error, no currency: " + e.getMessage());
        }

        while (!shouldCloseApp) {
            while (shouldMainMenuActive) {
                sortCurrencyList(currencyList);
                UserComunicator.printMainMenu(currencyList);
                choice = UserComunicator.getInputFromUser("Choose option");
                if (choice.equals("q")) {
                    shouldMainMenuActive =false;
                    shouldCloseApp = true;
                } else {
                    while (!isMainInputCorrect) {
                        isMainInputCorrect = UserComunicator.validateMainMenuChoice(choice, currencyList);
                        if (!isMainInputCorrect) {
                            UserComunicator.incorrectInputMessage();
                        }
                    }

                    shouldMainMenuActive = false;

                    choiceToInt = Integer.parseInt(choice) - 1;
                    chosenCurrency = currencyList.get(choiceToInt);

                    while (shouldSubMenuActive) {
                        UserComunicator.printSubMenu();
                        subMenuChoice = UserComunicator.getInputFromUser("To choose option press from 1 to 5");
                        while (!isSubInputCorrect) {
                            isSubInputCorrect = UserComunicator.validateSubMenuChoice(subMenuChoice);
                            UserComunicator.incorrectInputMessage();
                        }
                        switch (subMenuChoice) {
                            case "q":
                                shouldCloseApp = true;
                            case "b":
                                shouldSubMenuActive = false;
                                shouldMainMenuActive = true;
                            case "1":
                                try {
                                    System.out.println(chosenCurrency.todayPrice());
                                    break;
                                } catch (NoSuchElementException e) {
                                    System.out.println("Sorry we do not have price for today yet.");
                                    while (!isLastInputCorrect) {
                                        String c = UserComunicator.getInputFromUser("Type 'c' to continue or 'm' to Main Menu.");
                                        if (c.equals("c")) {
                                            shouldMainMenuActive = false;
                                            shouldSubMenuActive = true;
                                            isLastInputCorrect = true;
                                            isSubInputCorrect = false;
                                        } else if (c.equals("m")) {
                                            shouldSubMenuActive = false;
                                            shouldMainMenuActive = true;
                                            isLastInputCorrect = true;
                                        } else {
                                            UserComunicator.incorrectInputMessage();
                                            isLastInputCorrect = false;
                                        }
                                    }
                                    break;
                                }
                            case "2":
                                //2 - Exchange rate history.");
                            case "3":
                                while (!isDateCorrect) {
                                    dateFromUser = UserComunicator.getInputFromUser("Provide date (YYYY-MM-DD)");
                                    isDateCorrect = UserComunicator.validateDateFromUser(dateFromUser);
                                }
                                System.out.println((chosenCurrency.selectedDayPrice(LocalDate.parse(dateFromUser))));
                                while (!isLastInputCorrect) {
                                    String c = UserComunicator.getInputFromUser("Type 'c' to continue or 'm' to Main Menu.");
                                    if (c.equals("c")) {
                                        shouldMainMenuActive = false;
                                        shouldSubMenuActive = true;
                                        isLastInputCorrect = true;
                                        isSubInputCorrect = false;
                                    } else if (c.equals("m")) {
                                        shouldSubMenuActive = false;
                                        shouldMainMenuActive = true;
                                        isLastInputCorrect = true;
                                    } else {
                                        UserComunicator.incorrectInputMessage();
                                        isLastInputCorrect = false;
                                    }
                                }
                                break;
                            case "4":
                                System.out.println("Global max price: " + currencyList.get(choiceToInt).maxPrice() + " USD");
                                System.out.println("Global min price: " + currencyList.get(choiceToInt).minPrice() + " USD");
                                while (!isLastInputCorrect) {
                                    String c = UserComunicator.getInputFromUser("Type 'c' to continue or 'm' to Main Menu.");
                                    if (c.equals("c")) {
                                        shouldMainMenuActive = false;
                                        shouldSubMenuActive = true;
                                        isLastInputCorrect = true;
                                        isSubInputCorrect = false;
                                    } else if (c.equals("m")) {
                                        shouldSubMenuActive = false;
                                        shouldMainMenuActive = true;
                                        isLastInputCorrect = true;
                                    } else {
                                        UserComunicator.incorrectInputMessage();
                                        isLastInputCorrect = false;
                                    }
                                }
                                break;
                            case "5":
//                        System.out.println("Max price in interval: " + currencyList.get(choiceToInt).maxPriceInDateRange(startDate,endDate) + " USD");
//                        System.out.println("Min price in interval: " + currencyList.get(choiceToInt).minPriceInDateRange(startDate,endDate) + " USD");
                        }
                    }
                }
            }
        }
        System.exit(0);
    }


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

*//*
    private static void subMenuOutput(LocalDate date, int choice, List<Currency> currencyList){
        switch (choice){
            case 1:
                System.out.println(currencyList.get(choice).todayPrice());
            case 2:
                currencyList.stream()
                        .
        }

    }
*//*
 */




