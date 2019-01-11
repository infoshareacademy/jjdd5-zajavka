package com.infoshareacademy.zajavka.service;

import com.infoshareacademy.zajavka.data.Currency;
import com.infoshareacademy.zajavka.data.DailyData;
import com.infoshareacademy.zajavka.data.ListDirectoryException;

import javax.enterprise.context.ApplicationScoped;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class CurrencyService {

    private List<Currency> currencies;

    public void loadCurrencies(String path) throws ListDirectoryException {
        FileReader fileReader = new FileReader();
        this.currencies = fileReader.getCurrenciesFromDirectory(path);
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }

    public boolean checkDatesPrice(List<DailyData> list) {
        List<LocalDate> listDatesWithPrices = list.stream()
                .sorted(Comparator.comparing(DailyData::getDate))
                .filter(d ->d.getPriceUSD().compareTo(BigDecimal.ZERO) > 0)
                .map(DailyData::getDate)
                .collect(Collectors.toList());
    }
    }
}
