package com.infoshareacademy.zajavka.service;

import com.infoshareacademy.zajavka.dao.DailyDataDao;
import com.infoshareacademy.zajavka.data.DailyData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class DailyDataService {

    @Inject
    DailyDataDao dailyDataDao;

    private static final Logger LOG = LoggerFactory.getLogger(DailyDataService.class);


    public boolean checkInputsForTimeRange(String startDate, String endDate, List<LocalDate> list){
        try {
            LocalDate parsedDate = LocalDate.parse(startDate);
            LocalDate parsedDate2 = LocalDate.parse(endDate);
            return (list.contains(parsedDate) && list.contains(parsedDate2) && parsedDate.isBefore(parsedDate2));
        }
        catch (DateTimeParseException e) {
            LOG.error("Incorrect input  date format " + e);
            return false;
        }
    }

    public boolean checkIfListContainPrice(String date, List<LocalDate> list) {
        try {
            LocalDate parsedDate = LocalDate.parse(date);
            return list.contains(parsedDate);

        }
        catch (DateTimeParseException e) {
            LOG.error("Incorrect input  date format " + e);
            return false;
        }
    }

    public List<LocalDate> getListDatesWithPrices(String currency){

        List<DailyData> list = dailyDataDao.getAllDailyDatasForCurrency(currency);


        return list.stream()
                .sorted(Comparator.comparing(DailyData::getDate))
                .filter(d ->d.getPriceUSD().compareTo(BigDecimal.ZERO) > 0)
                .map(DailyData::getDate)
                .collect(Collectors.toList());
    }

    public LocalDate getFirstDayWithPrice(List<LocalDate> list){
        return list.get(0);
    }

    public LocalDate getLastDayWithPrice(List<LocalDate> list){
        return list.get(list.size() - 1);
    }
}
