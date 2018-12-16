package com.infoshareacademy.zajavka.web;

import com.infoshareacademy.zajavka.dao.ConfigurationDao;
import com.infoshareacademy.zajavka.dao.CurrencyNameDao;
import com.infoshareacademy.zajavka.freemarker.TemplateProvider;
import com.infoshareacademy.zajavka.service.ConfigurationService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
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
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/currency-name")
@Transactional
public class CurrencyNameServlet extends HttpServlet {

    private Logger LOG = LoggerFactory.getLogger(ConfigurationServlet.class);

    private static final String TEMPLATE_NAME = "currencyName";

    @Inject
    private CurrencyNameDao currencyNameDao;

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private ConfigurationDao configurationDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Template template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME);

        Map<String, Object> model = new HashMap<>();

        Map<String,String> currencyList = currencyNameDao.findAllMap();

        model.put("currencyList", currencyList.entrySet());

//        model.put("aaa", configurationService.);
        /*
        final List<CurrencyName> result = currencyNameDao.findAll();
        LOG.info("Found {} objects", result.size());
        for (CurrencyName c : result) {
            resp.getWriter().write(c.toString() + "\n");*/

        String aa = configurationDao.findValue("dateFormat");

        model.put("ada", aa);

       /*
        config.put("dateFormat", configurationDao.findValue("dateFormat"));
        config.put("afterSign", configurationDao.findValue("afterSign"));*/

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            LOG.error("Error while processing the template: " + e.getMessage());
            e.printStackTrace();
        }

        }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

