package com.infoshareacademy.zajavka.service;

import com.infoshareacademy.zajavka.data.Currency;
import com.infoshareacademy.zajavka.data.ListDirectoryException;
import com.infoshareacademy.zajavka.data.ReadFileException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileReader {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileReader.class);

    public List<Currency> getCurrenciesFromDirectory(String dirPath) throws ListDirectoryException {
        List<String> fileNamesWithExtension = listFilesForFolder(Paths.get(dirPath));
        return getCurrencyDataListFromfiles(dirPath, fileNamesWithExtension);
    }

    private List<String> listFilesForFolder(final Path path) throws ListDirectoryException {
        List<String> fileList = new ArrayList<>();

        LOGGER.info("Scanning directory");
        try (Stream<Path> filePathStream = Files.walk(path)) {
            filePathStream.forEach(filePath -> {
                if (Files.isRegularFile(filePath)) {
                    fileList.add(filePath.getFileName().toString());
                }
            });
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
            throw new ListDirectoryException(e.getMessage());
        }

        return fileList;
    }

    private List<Currency> getCurrencyDataListFromfiles(String dirPath, List<String> fileNamesWithExtension) {
        List<Currency> currencyDataList = new ArrayList<>();
        for (String actFileNameWithExt : fileNamesWithExtension) {
            Path filePathWithName = Paths.get(dirPath, actFileNameWithExt);
            try {
                List<String> dalyDataListForFile = readAllLinesFile(filePathWithName);
                if (dalyDataListForFile.size()>1) {
                    currencyDataList.add(new Currency(actFileNameWithExt, dalyDataListForFile));
                }
            } catch (ReadFileException e) {
                LOGGER.error(e.getMessage());
                System.out.printf("Error with reading %s file.\n", actFileNameWithExt);
            }
        }
        return currencyDataList;

    }

    private List<String> readAllLinesFile(final Path path) throws ReadFileException {
        List<String> file = null;
        try {
            file = Files.readAllLines(path);
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
            throw new ReadFileException(e.getMessage());
        }

        return file;
    }

}
