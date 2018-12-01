package com.infoshareacademy.zajavka.console;

import org.slf4j.LoggerFactory;

import java.util.logging.Logger;

import static com.infoshareacademy.zajavka.console.Menu.createMainMenu;

public class App {

    //   private statc final Logger LOGGER = LoggerFactory.getLogger(Menu.class);

    public static void main(String[] args) {
        if (args.length != 1) {
 //           LOGGER.error("Incorrect parameters provided");
            System.exit(1);
        }
        createMainMenu(args[0]);
    }
}
