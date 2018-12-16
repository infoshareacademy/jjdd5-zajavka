package com.infoshareacademy.zajavka.service;

import com.infoshareacademy.zajavka.dao.ConfigurationDao;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ConfigurationService {

    @Inject
    private ConfigurationDao configurationDao;

    private String dateFormatAA = configurationDao.findValue("dateFormat");
    private String afterSign = configurationDao.findValue("afterSign");



}
