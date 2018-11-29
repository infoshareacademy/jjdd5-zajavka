package com.infoshareacademy.zajavka.data;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Currency {

    private static final String EMPTY_STRING = "";
    private static final String SEPARATOR = ",";
    private static final int INDEX_DATE = 0;
    private static final int INDEX_TX_VOLUME_USD = 1;
    private static final int INDEX_ADJ_TX_VOLUME_USD = 2;
    private static final int INDEX_TX_COUNT = 3;
    private static final int INDEX_MARCET_CAP_USD = 4;
    private static final int INDEX_PRICE_USD = 5;
    private static final int INDEX_EX_VOLUME_USD = 6;
    private static final int INDEX_GENERATED_COINS = 7;
    private static final int INDEX_FEES = 8;
    private static final int INDEX_ACTIVE_ADRESESS = 9;
    private static final int INDEX_AVERAGE_DIFFICULTY = 10;
    private static final int INDEX_PAYMENT_COUNT = 11;
    private static final int INDEX_MEDIAN_TX_VALUE_USD = 12;
    private static final int INDEX_MEDIAN_FEE = 13;
    private static final int INDEX_BLOCK_SIZE = 14;
    private static final int INDEX_BLOCK_COUNT = 15;
    private static final int DAILY_DATA_LENGTH = 16;

    private String name;
    private List<DailyData> dailyDataList = new ArrayList<>();

    private static final Logger LOGGER = LoggerFactory.getLogger(Currency.class);


    public Currency(String name, List<String> dailyDataList) {
        this.name = name;
        for (int j = 1; j < dailyDataList.size(); j++) {
            addDailyData(dailyDataList.get(j).split(SEPARATOR));
        }
    }

    private BigDecimal stringToBigDecimal(String value) {
        try {
            return new BigDecimal(value);
        } catch (Exception e) {
            LOGGER.error("Error at try read Date for " + name +": " +e.getMessage());
            System.out.println("Error at try read Date for " + name);
            return null;
        }
    }

    private LocalDate stringToLocalDate(String value) {
        try {
            return LocalDate.parse(value);
        } catch (Exception e) {
            LOGGER.error("Error " + value + "has't corret number format in " + name+ ": " +e.getMessage());
            System.out.println("Error " + value + "has't corret number format in " + name);
            return null;
        }
    }

    public void addDailyData(String[] dalyDataS) {
        DailyData daily = new DailyData();
        if (dalyDataS.length == DAILY_DATA_LENGTH) {
            daily.setDate(stringToLocalDate(dalyDataS[INDEX_DATE]));
            if (!dalyDataS[INDEX_TX_VOLUME_USD].equals(EMPTY_STRING)) {
                daily.setTxVolumeUSD(stringToBigDecimal(dalyDataS[INDEX_TX_VOLUME_USD]));
            }

            if (!dalyDataS[INDEX_ADJ_TX_VOLUME_USD].equals(EMPTY_STRING)) {
                daily.setAdjTxVolumeUSD(stringToBigDecimal(dalyDataS[INDEX_ADJ_TX_VOLUME_USD]));
            }

            if (!dalyDataS[INDEX_TX_COUNT].equals(EMPTY_STRING)) {
                daily.setTxCount(stringToBigDecimal(dalyDataS[INDEX_TX_COUNT]));
            }

            if (!dalyDataS[INDEX_MARCET_CAP_USD].equals(EMPTY_STRING)) {
                daily.setMarcetCapUSD(stringToBigDecimal(dalyDataS[INDEX_MARCET_CAP_USD]));
            }

            if (!dalyDataS[INDEX_PRICE_USD].equals(EMPTY_STRING)) {
                daily.setPriceUSD(stringToBigDecimal(dalyDataS[INDEX_PRICE_USD]));
            }
            if (!dalyDataS[INDEX_EX_VOLUME_USD].equals(EMPTY_STRING)) {
                daily.setExVolumeUSD(stringToBigDecimal(dalyDataS[INDEX_EX_VOLUME_USD]));
            }

            if (!dalyDataS[INDEX_GENERATED_COINS].equals(EMPTY_STRING)) {
                daily.setGeneratedCoins(stringToBigDecimal(dalyDataS[INDEX_GENERATED_COINS]));
            }

            if (!dalyDataS[INDEX_FEES].equals(EMPTY_STRING)) {
                daily.setFees(stringToBigDecimal(dalyDataS[INDEX_FEES]));
            }

            if (!dalyDataS[INDEX_ACTIVE_ADRESESS].equals(EMPTY_STRING)) {
                daily.setActiveAdresess(stringToBigDecimal(dalyDataS[INDEX_ACTIVE_ADRESESS]));
            }

            if (!dalyDataS[INDEX_AVERAGE_DIFFICULTY].equals(EMPTY_STRING)) {
                daily.setAverageDifficulty(stringToBigDecimal(dalyDataS[INDEX_AVERAGE_DIFFICULTY]));
            }

            if (!dalyDataS[INDEX_PAYMENT_COUNT].equals(EMPTY_STRING)) {
                daily.setPaymentCount(stringToBigDecimal(dalyDataS[INDEX_PAYMENT_COUNT]));
            }

            if (!dalyDataS[INDEX_MEDIAN_TX_VALUE_USD].equals(EMPTY_STRING)) {
                daily.setMedianTxValueUSD(stringToBigDecimal(dalyDataS[INDEX_MEDIAN_TX_VALUE_USD]));
            }

            if (!dalyDataS[INDEX_MEDIAN_FEE].equals(EMPTY_STRING)) {
                daily.setMedianFee(stringToBigDecimal(dalyDataS[INDEX_MEDIAN_FEE]));
            }

            if (!dalyDataS[INDEX_BLOCK_SIZE].equals(EMPTY_STRING)) {
                daily.setBlockSize(stringToBigDecimal(dalyDataS[INDEX_BLOCK_SIZE]));
            }

            if (!dalyDataS[INDEX_BLOCK_COUNT].equals(EMPTY_STRING)) {
                daily.setBlockCount(stringToBigDecimal(dalyDataS[INDEX_BLOCK_COUNT]));
            }

            dailyDataList.add(daily);

        }
    }

    public String getName() {
        return name;
    }

    public List<DailyData> getDailyDataList() {
        return dailyDataList;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "name='" + name + '\'' +
                ", dailyDataList=" + dailyDataList +
                '}';
    }

    public DailyData GetDataForDate(LocalDate xDate) {
        for (DailyData actDailyData : dailyDataList) {
            if (actDailyData.Date().equals(xDate)) {
                return actDailyData;
            }
        }
        return null;
    }

    public DailyData getDataForDate(LocalDate date) {
        for (DailyData daly : dailyDataList) {
            if (daly.Date().equals(date)) {
                return daly;
            }
        }
        return null;
    }
}
