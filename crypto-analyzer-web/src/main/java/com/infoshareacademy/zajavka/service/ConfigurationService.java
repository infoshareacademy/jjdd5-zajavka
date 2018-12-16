package com.infoshareacademy.zajavka.service;

import com.infoshareacademy.zajavka.dao.ConfigurationDao;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.format.DateTimeFormatter;

@ApplicationScoped
public class ConfigurationService {

    @Inject
    private ConfigurationDao configurationDao;

    private DateTimeFormatter dateFormatter(){
        String formatter = configurationDao.findValue("dateFormat");
        return DateTimeFormatter.ofPattern(formatter);
    }

    private Integer numberAfterSign() {
         String afterSignNumber = configurationDao.findValue("afterSign");
         return Integer.valueOf(afterSignNumber);
    }

}
