package com.infoshareacademy.zajavka.service;

import com.infoshareacademy.zajavka.dao.ConfigurationDao;
import com.infoshareacademy.zajavka.data.Configuration;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.format.DateTimeFormatter;

@ApplicationScoped
public class ConfigurationService {

    @Inject
    private ConfigurationDao configurationDao;


    public DateTimeFormatter dateFormatter(){
        String formatter = configurationDao.findValue("dateFormat");
        return DateTimeFormatter.ofPattern(formatter);
    }

    public Integer numberAfterSign() {
         Configuration afterSignNumber = configurationDao.findById("afterSign");
         String afterString = afterSignNumber.getValue();
         return Integer.valueOf(afterString);
    }


}
