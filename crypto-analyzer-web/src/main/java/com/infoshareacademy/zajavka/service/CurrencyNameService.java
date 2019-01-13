package com.infoshareacademy.zajavka.service;


import com.infoshareacademy.zajavka.dao.CurrencyDao;
import com.infoshareacademy.zajavka.dao.CurrencyNameDao;
import com.infoshareacademy.zajavka.data.Currency;
import com.infoshareacademy.zajavka.data.CurrencyName;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.*;

@ApplicationScoped
public class CurrencyNameService {

    @Inject
    private CurrencyNameDao currencyNameDao;

    @Inject
    private CurrencyDao currencyDao;

    public Map<String, String> CurrencyList() {
        List<String> listCurrencyDatabase = currencyDao.getNames();
        Map<String, String> CurrencyList = new HashMap<>();
        if (listCurrencyDatabase.isEmpty()) {
            return CurrencyList;
        } else {
            for (int i = 0; i < listCurrencyDatabase.size(); i++) {
                String firstValue = listCurrencyDatabase.get(i);
                if (currencyNameDao.findById(firstValue) == null) {
                    CurrencyList.put(firstValue, firstValue.replace(".csv", ""));
                } else if (firstValue.equals(currencyNameDao.findById(firstValue).getNameFile())) {
                    CurrencyList.put(firstValue, currencyNameDao.findById(firstValue).getNameCurrency());
                } else {
                    CurrencyList.put(firstValue, firstValue.replace(".csv", ""));
                }
            }
            return CurrencyList;
        }
    }

}
