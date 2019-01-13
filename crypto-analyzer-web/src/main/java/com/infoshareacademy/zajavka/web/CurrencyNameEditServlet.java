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
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/currency-name-edit")
@Transactional
public class CurrencyNameEditServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(CurrencyNameEditServlet.class);
    private static final String TEMPLATE_NAME = "currencyNameEdit";

    @Inject
    private CurrencyNameDao currencyNameDao;

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String editCurrencyName = req.getParameter("name");
        CurrencyName currencyName = currencyNameDao.findById(editCurrencyName);

        Template template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME);

        Map<String, Object> getCurrencyName = new HashMap<>();
        getCurrencyName.put("editCurrencyName1", currencyName);


        try {
            template.process(getCurrencyName, resp.getWriter());
        } catch (TemplateException e) {
            LOG.error("Error while processing the template: " + e.getMessage());
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String fileName = req.getParameter("fileName");
        final String currencyName = req.getParameter("currencyName");
        final String promotion = req.getParameter("promotion");
        CurrencyName newCurrency = new CurrencyName(fileName, currencyName, promotion);

        currencyNameDao.update(newCurrency);

        resp.sendRedirect("/currency-name");
    }
}
