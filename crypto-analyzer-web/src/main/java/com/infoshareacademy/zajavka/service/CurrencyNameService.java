package com.infoshareacademy.zajavka.service;

import com.infoshareacademy.zajavka.dao.CurrencyNameDao;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CurrencyNameService {

    @Inject
    private CurrencyNameDao currencyNameDao;

    /*public changeNameCurrency(){

    }*/
}
