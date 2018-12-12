package com.infoshareacademy.zajavka.service;


import com.infoshareacademy.zajavka.dao.CurrencyDao;
import com.infoshareacademy.zajavka.dao.DailyDataDao;
import com.infoshareacademy.zajavka.data.Currency;
import com.infoshareacademy.zajavka.data.DailyData;
import com.infoshareacademy.zajavka.data.ListDirectoryException;
import com.infoshareacademy.zajavka.data.ReadFileException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static com.infoshareacademy.zajavka.service.UnzipService.EXTRACTED_DATA_PATH;

@Stateless
public class ReadFilesToBase {

    private static final String EMPTY_STRING = "";
    private static final String SEPARATOR = ",";
    private static final int INDEX_DATE = 0;
    private static final int INDEX_PRICE_USD = 5;
    private static final int DAILY_DATA_LENGTH = 16;
    private static final Logger LOG = LoggerFactory.getLogger(ReadFilesToBase.class);

    @Inject
    private CurrencyDao currencyDao;

    @Inject
    private DailyDataDao dailyDataDao;

    public List GetFileNames() throws ListDirectoryException {
        List<String> fileList = new ArrayList<>();

        LOG.info("Scanning directory");
        try (Stream<Path> filePathStream = Files.walk(Paths.get(EXTRACTED_DATA_PATH))) {
            filePathStream.forEach(filePath -> {
                if (Files.isRegularFile(filePath) && filePath.toString().endsWith(".csv")) {
                    LOG.info("Found csv file: " + filePath.getFileName().toString());
                    fileList.add(filePath.getFileName().toString());
                } else {
                    LOG.info("Skipping file: " + filePath.getFileName().toString());
                }
            });
        } catch (IOException e) {
            LOG.error(e.getMessage());
            throw new ListDirectoryException(e.getMessage());
        }

        return fileList;
    }

    public void ReadFilesAndSaveInBase (List<String> names){
        for (String actFileNameWithExt : names) {
            Path filePathWithName = Paths.get(EXTRACTED_DATA_PATH, actFileNameWithExt);
            try {
                List<String> dalyDataListForFile = readAllLinesFile(filePathWithName);
                if (dalyDataListForFile.size() > 1) {
                    saveToBase(actFileNameWithExt, dalyDataListForFile );
                    LOG.info("File is read: " + actFileNameWithExt);
                } else {
                    LOG.info("File is empty: " + actFileNameWithExt);
                }
            } catch (ReadFileException e) {
                LOG.error(e.getMessage());
            }
        }
    }

    private List<String> readAllLinesFile(final Path path) throws ReadFileException {
        List<String> file;
        try {
            file = Files.readAllLines(path);
        } catch (IOException e) {
            LOG.error(e.getMessage());
            throw new ReadFileException(e.getMessage());
        }

        return file;
    }

    private void saveToBase(String actFileNameWithExt, List<String> dalyDataListForFile ){

        Currency currency = new Currency(actFileNameWithExt);
        currencyDao.save(currency);
        for (int i=1; i < dalyDataListForFile.size(); i++) {
                String[] parseDay = dalyDataListForFile.get(i).split(SEPARATOR);

                if (parseDay.length == DAILY_DATA_LENGTH && !parseDay[INDEX_DATE].equals(EMPTY_STRING) && !parseDay[INDEX_PRICE_USD].equals(EMPTY_STRING)) {
                    try {
                        DailyData dailyData = new DailyData();
                        dailyData.setCurrency(currency);
                        dailyData.setDate(LocalDate.parse(parseDay[INDEX_DATE]));
                        dailyData.setPriceUSD(new BigDecimal(parseDay[INDEX_PRICE_USD]));

                        dailyDataDao.save(dailyData);
                    } catch (Exception e) {
                        LOG.error("Cannot save dailyData: {}", e.getMessage());
                    }
                }
        }

    }
}
