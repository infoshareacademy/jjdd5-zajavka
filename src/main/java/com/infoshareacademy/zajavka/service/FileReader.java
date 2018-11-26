package com.infoshareacademy.zajavka.service;

import com.infoshareacademy.zajavka.data.Currency;
import com.infoshareacademy.zajavka.data.ListDirectoryException;
import com.infoshareacademy.zajavka.data.ReadFileException;
import com.sun.org.apache.xerces.internal.xs.StringList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileReader {

    //private List<Currency> currencyList = new ArrayList<>();
    private String pathToData = "data";

    public List<Currency> getCurrenciesFromDirectory(String dirPath) throws ReadFileException, ListDirectoryException {
        List<String> fileNamesWithExtension;

        fileNamesWithExtension = listFilesForFolder(Paths.get(pathToData));
        return getCurrencyDataListFromfiles(fileNamesWithExtension);
        //readFile(null);
        // forEach load data from file
        // return list
        //return null;
    }



    private List<String> listFilesForFolder(final Path path) throws ListDirectoryException {
        List<String> fileList = new ArrayList<>();

        try (Stream<Path> filePathStream = Files.walk(path)) {
            filePathStream.forEach(filePath -> {
                if (Files.isRegularFile(filePath)) {
                    fileList.add(filePath.getFileName().toString());
                }
            });
        } catch (IOException e) {
            // log info ze cos nie tak
            throw new ListDirectoryException(e.getMessage());
        }

        return fileList;
    }

    private List<Currency> getCurrencyDataListFromfiles(List<String> fileNamesWithExtension) {
        List<Currency> currencyDataList = new ArrayList<>();
        for (String actFileNameWithExt : fileNamesWithExtension) {
            Path filePathWithName = Paths.get(pathToData,actFileNameWithExt);
            try {
                List<String> dalyDataListForFile = readFile(filePathWithName);
                currencyDataList.add(new Currency(actFileNameWithExt,dalyDataListForFile));
            } catch (ReadFileException e) {
                e.printStackTrace();
            }
        }
        return  currencyDataList;

    }

    private List<String> readFile(final Path path) throws ReadFileException {
        List<String> file = null;
        try {
            file = Files.readAllLines(path);
        } catch (IOException e) {
            // log info ze cos nie tak
            throw new ReadFileException(e.getMessage());
        }

        return file;
    }


}
