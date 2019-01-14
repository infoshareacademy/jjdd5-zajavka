package com.infoshareacademy.zajavka.service;

import com.infoshareacademy.zajavka.dao.ConfigurationDao;
import com.infoshareacademy.zajavka.data.Configuration;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.format.DateTimeFormatter;

@ApplicationScoped
@ManagedBean
public class ConfigurationService {

    @Inject
    private ConfigurationDao configurationDao;

  /*  @PostConstruct
    public void insertConfiguration() {
        Configuration c1 = new Configuration("dateFormat", "dd-MM-yyyy");
        Configuration c2 = new Configuration("afterSign", "2");
        configurationDao.save(c1);
        configurationDao.save(c2);
    }*/

    public DateTimeFormatter dateFormatter() {
        String formatter = configurationDao.findValue("dateFormat");
        return DateTimeFormatter.ofPattern(formatter);
    }

    public Integer numberAfterSign() {
        Configuration afterSignNumber = configurationDao.findById("afterSign");
        String afterString = afterSignNumber.getValue();
        return Integer.valueOf(afterString);
    }

    public String dateFormat() {
        return configurationDao.findValue("dateFormat");
    }


}
