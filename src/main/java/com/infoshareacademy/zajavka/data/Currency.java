package com.infoshareacademy.zajavka.data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Currency {

    private static final String EMPTY_STRING = "";

    private String name;
    private List<DailyData> dailyDataList = new ArrayList<>();

    public Currency(String name) {
        this.name = name;
    }

    public void addDailyData(DailyData dailyData) {
        this.dailyDataList.add(dailyData);
    }

    public void addDailyData(String[] dalyDataS) {
        DailyData daly = new DailyData();
        daly.setDate(LocalDate.parse(dalyDataS[0]));
        if (!dalyDataS[1].equals(EMPTY_STRING)) {
            daly.setTxVolumeUSD(new BigDecimal(dalyDataS[1]));
        }
        if (!dalyDataS[2].equals(EMPTY_STRING)) {
            daly.setAdjTxVolumeUSD(new BigDecimal(dalyDataS[2]));
        }
        if (!dalyDataS[3].equals(EMPTY_STRING)) {
            daly.setTxCount(new BigDecimal(dalyDataS[3]));
        }
        if (!dalyDataS[4].equals(EMPTY_STRING)) {
            daly.setMarcetCapUSD(new BigDecimal(dalyDataS[4]));
        }
        if (!dalyDataS[5].equals(EMPTY_STRING)) {
            daly.setPriceUSD(new BigDecimal(dalyDataS[5]));
        }
        if (!dalyDataS[6].equals(EMPTY_STRING)) {
            daly.setExVolumeUSD(new BigDecimal(dalyDataS[6]));
        }
        if (!dalyDataS[7].equals(EMPTY_STRING)) {
            daly.setGeneratedCoins(new BigDecimal(dalyDataS[7]));
        }
        if (!dalyDataS[8].equals(EMPTY_STRING)) {
            daly.setFees(new BigDecimal(dalyDataS[8]));
        }
        if (!dalyDataS[9].equals(EMPTY_STRING)) {
            daly.setActiveAdresess(new BigDecimal(dalyDataS[9]));
        }
        if (!dalyDataS[10].equals(EMPTY_STRING)) {
            daly.setAverageDifficulty(new BigDecimal(dalyDataS[10]));
        }
        if (!dalyDataS[11].equals(EMPTY_STRING)) {
            daly.setPaymentCount(new BigDecimal(dalyDataS[11]));
        }
        if (!dalyDataS[12].equals(EMPTY_STRING)) {
            daly.setMedianTxValueUSD(new BigDecimal(dalyDataS[12]));
        }
        if (!dalyDataS[13].equals(EMPTY_STRING)) {
            daly.setMedianFee(new BigDecimal(dalyDataS[13]));
        }
        if (!dalyDataS[14].equals(EMPTY_STRING)) {
            daly.setBlockSize(new BigDecimal(dalyDataS[14]));
        }
        if (!dalyDataS[15].equals(EMPTY_STRING)) {
            daly.setBlockCount(new BigDecimal(dalyDataS[15]));
        }

        dailyDataList.add(daly);
    }

    public BigDecimal maxPrice() {
        return dailyDataList.stream()
                .filter(s -> s.getPriceUSD() != null)
                .max(Comparator.comparing(DailyData::getPriceUSD))
                .get().getPriceUSD();
    }

    public BigDecimal minPrice() {
        return dailyDataList.stream()
                .filter(s -> s.getPriceUSD() != null)
                .min(Comparator.comparing(DailyData::getPriceUSD))
                .get().getPriceUSD();
    }



    public BigDecimal maxPriceInDateRange(LocalDate startDate, LocalDate endDate) {
        return dailyDataList.stream()
                .filter(s -> s.getPriceUSD() != null)
                .filter(s -> endDate.isAfter(s.getDate()) && startDate.isBefore(s.getDate()))
                .max(Comparator.comparing(DailyData::getPriceUSD))
                .get().getPriceUSD();
    }


    public BigDecimal minPriceInDateRange(LocalDate startDate, LocalDate endDate) {
        return dailyDataList.stream()
                .filter(s -> s.getPriceUSD() != null)
                .filter(s -> endDate.isAfter(s.getDate()) && startDate.isBefore(s.getDate()))
                .min(Comparator.comparing(DailyData::getPriceUSD))
                .get().getPriceUSD();
    }

    public LocalDate readDateFromConsole() {
        System.out.println("Please insert the date in correct format: RRRR-MM-DD");
        Scanner scanner = new Scanner(System.in);
        try {
            return LocalDate.parse(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Incorrect format of date");

        }
        return readDateFromConsole();
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
