package com.infoshareacademy.zajavka.configuration;

import java.util.Properties;

public class Configuration {


    private final Properties properties;

    public Configuration(Properties properties){this.properties = properties;}

    public String getCharForSeparate() { return properties.getProperty("charForSeparate");  }

    public int getAmountNumberAfterSign() {
        //problemy
        return properties.getProperty("amountNumberAfterSign");
    }
}
