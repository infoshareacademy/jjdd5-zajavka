package com.infoshareacademy.zajavka.service;

import com.infoshareacademy.zajavka.data.Currency;
import com.infoshareacademy.zajavka.data.ListDirectoryException;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

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
}
