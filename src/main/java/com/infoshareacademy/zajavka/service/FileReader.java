package com.infoshareacademy.zajavka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileReader {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileReader.class);

    public static ArrayList listFilesForFolder(final Path path) {
        ArrayList<String> fileList = new ArrayList<>();

        LOGGER.info("Scanning directory");
        try (Stream<Path> filePathStream = Files.walk(path)) {
            filePathStream.forEach(filePath -> {
                if (Files.isRegularFile(filePath)) {
                    fileList.add(filePath.getFileName().toString());
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage());
        }

        return fileList;

    }

    public static List readFile(final Path path) {
        List<String> file = null;
        try {
            file = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage());

        }

        return file;
    }

}
