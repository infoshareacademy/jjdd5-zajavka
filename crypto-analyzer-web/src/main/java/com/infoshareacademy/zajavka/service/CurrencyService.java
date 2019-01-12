package com.infoshareacademy.zajavka.service;

import com.infoshareacademy.zajavka.data.Currency;
import com.infoshareacademy.zajavka.data.ListDirectoryException;

import javax.enterprise.context.ApplicationScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

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


    public void setActiveCurrency(HttpServletRequest req, Map<String, Object> model) {
        HttpSession session = req.getSession();
        String currency = (String) session.getAttribute("currency");

        if (currency == null || currency.isEmpty()) {
            currency = "not selected.";
            model.put("chosenCurrency", currency);
            model.put("isCurrencyActive",false);

        } else {
            model.put("isCurrencyActive",true);
            model.put("chosenCurrency", currency);
        }
    }

    public boolean isCurrencyNotSelected(String currency) {
        return (currency == null || currency.isEmpty());
    }

}