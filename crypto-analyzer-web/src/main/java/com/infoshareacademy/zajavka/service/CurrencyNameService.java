package com.infoshareacademy.zajavka.service;


import com.infoshareacademy.zajavka.dao.CurrencyNameDao;
import com.infoshareacademy.zajavka.data.CurrencyName;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
@ManagedBean
public class CurrencyNameService {

    @Inject
    private CurrencyNameDao currencyNameDao;

    @PostConstruct
    public void insertCurrencyNames(){
        CurrencyName c1 = new CurrencyName("doge.csv", "Dodge");
        CurrencyName c2 = new CurrencyName("btc.csv", "Bitcoin");
        currencyNameDao.save(c1);
        currencyNameDao.save(c2);
    }

}
