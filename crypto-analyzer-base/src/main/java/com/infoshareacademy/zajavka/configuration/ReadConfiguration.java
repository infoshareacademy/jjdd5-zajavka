package com.infoshareacademy.zajavka.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;

public class ReadConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReadConfiguration.class);

    public static Configuration loadProperties() {
        try (InputStream resourceAsStream = ReadConfiguration.class.getResourceAsStream("configuration.properties")) {
            Properties properties = new Properties();
            properties.load(resourceAsStream);
            return new Configuration(properties);

        } catch (IOException e) {
            LOGGER.error("Error no file configuration: " + e.getMessage());
            throw new UncheckedIOException(e);
        }
    }
}