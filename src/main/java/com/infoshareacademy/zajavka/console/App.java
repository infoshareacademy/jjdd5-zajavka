package com.infoshareacademy.zajavka.console;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import static com.infoshareacademy.zajavka.console.Menu.createMainMenu;

public class App {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        if (args.length != 1) {
            LOGGER.error("Incorrect parameters provided");
            System.exit(1);
        }
        LOGGER.info("<<-- Run Crypto Analyzer apllication -->>");
        createMainMenu(args[0]);
    }
}
