package com.infoshareacademy.zajavka.web;

import com.infoshareacademy.zajavka.configuration.Configuration;

import com.infoshareacademy.zajavka.data.ListDirectoryException;
import com.infoshareacademy.zajavka.freemarker.TemplateProvider;
import com.infoshareacademy.zajavka.service.CurrencyService;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.*;

import static com.infoshareacademy.zajavka.configuration.ReadConfiguration.loadProperties;

@WebServlet(urlPatterns = "/load")
public class LoadFileServlet extends HttpServlet {

    private Configuration configuration;
    private static final String TEMPLATE_NAME = "loadFile";
    private final Logger log = LoggerFactory.getLogger(LoadFileServlet.class);

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private CurrencyService currencyService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        configuration = null;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> model = new HashMap<>();
        processTemplate(model, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            Map<String, Object> model = new HashMap<>();
            //currencyService.loadCurrencies("/home/danielmodrzejewski/Filereader/jjdd5-zajavka/data");
            currencyService.loadCurrencies("/home/bartosz/IdeaProjects/jjdd5-zajavka/data");
            model.put("Currency", currencyService.getCurrencies());

            processTemplate(model, resp);
        } catch (ListDirectoryException e) {
            log.warn("Error on currency loading:");

        }
    }

    private void processTemplate(Map<String, Object> model, HttpServletResponse resp) throws IOException {
        Template template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME);
        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}