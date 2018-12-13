package com.infoshareacademy.zajavka.web;

import com.infoshareacademy.zajavka.dao.CurrencyNameDao;
import com.infoshareacademy.zajavka.data.CurrencyName;
import com.infoshareacademy.zajavka.freemarker.TemplateProvider;
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
import java.util.List;

@WebServlet(urlPatterns = "/currency-name")
@Transactional
public class CurrencyNameServlet extends HttpServlet {

    private Logger LOG = LoggerFactory.getLogger(ConfigurationServlet.class);

    private static final String TEMPLATE_NAME = "currencyName";

    @Inject
    private CurrencyNameDao currencyNameDao;

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Template template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME);

        final List<CurrencyName> result = currencyNameDao.findAll();
        LOG.info("Found {} objects", result.size());
        for (CurrencyName c : result) {
            resp.getWriter().write(c.toString() + "\n");


       /*
        Map<String, Object> nameCurrency = new HashMap<>();
        currencyNameDao.findAll().stream().forEach();


        config.put("dateFormat", configurationDao.findValue("dateFormat"));
        config.put("afterSign", configurationDao.findValue("afterSign"));

        try {
            template.process(config, resp.getWriter());
        } catch (TemplateException e) {
            LOG.error("Error while processing the template: " + e.getMessage());
            e.printStackTrace();
        }*/

        }
    }
}
