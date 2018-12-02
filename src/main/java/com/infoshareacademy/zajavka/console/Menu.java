package com.infoshareacademy.zajavka.console;

import com.infoshareacademy.zajavka.data.Currency;
import com.infoshareacademy.zajavka.data.ListDirectoryException;
import com.infoshareacademy.zajavka.service.FileReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

class Menu {
    private static final Logger LOGGER = LoggerFactory.getLogger(Menu.class);

    static void createMainMenu(String dirPath) {
        List<Currency> currencyList = new ArrayList<>();
        FileReader fileReader = new FileReader();
        try {
            currencyList = fileReader.getCurrenciesFromDirectory(dirPath);
        } catch (ListDirectoryException e) {
            LOGGER.error("Error, no currency: " + e.getMessage());
        }
        while (true) {
            UserComunicator.printMainMenu(currencyList);
            int usersChoice = UserComunicator.getInputFromUser(currencyList, "Enter: ");
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