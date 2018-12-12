package com.infoshareacademy.zajavka.web;

import com.infoshareacademy.zajavka.dao.ConfigurationDao;
import com.infoshareacademy.zajavka.freemarker.TemplateProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;

@WebServlet(urlPatterns = "/configuration")
@Transactional
public class ConfigurationServlet extends HttpServlet {

    private Logger log = LoggerFactory.getLogger(ConfigurationServlet.class);

    @Inject
    private ConfigurationDao configurationDao;

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
