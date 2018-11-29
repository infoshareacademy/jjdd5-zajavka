package com.infoshareacademy.zajavka.configuration;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.Properties;

public class ReadConfiguration {

    public static Configuration loadProperties() {
        try (InputStream resourceAsStream = new FileInputStream("config/configuration.properties")) {
            Properties properties = new Properties();
            properties.load(resourceAsStream);

            return new Configuration(properties);

        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }


}