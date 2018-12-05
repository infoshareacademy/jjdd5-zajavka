package com.infoshareacademy.zajavka.configuration;

import java.time.format.DateTimeFormatter;
import java.util.Properties;


public class Configuration {

    private final Properties properties;

    public Configuration(Properties properties) {
        this.properties = properties;
    }

    public String getCharForSeparate() {
        return properties.getProperty("charForSeparate");
    }

    public int getAmountNumberAfterSign() {
        return Integer.parseInt(properties.getProperty("amountNumberAfterSign"));
    }

    public DateTimeFormatter getDateFormat() {
        return DateTimeFormatter.ofPattern(properties.getProperty("dateFormat"));
    }

    public String getNameCurrency(String a) {
        return properties.getProperty(a.replaceAll(".csv", ""));
    }
}
