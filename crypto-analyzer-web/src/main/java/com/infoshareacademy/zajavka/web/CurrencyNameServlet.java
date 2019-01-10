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
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/currency-name")
@Transactional
public class CurrencyNameServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(CurrencyNameServlet.class);
    private static final String TEMPLATE_NAME = "currencyName";
    @Inject
    private CurrencyNameDao currencyNameDao;
    @Inject
    private TemplateProvider templateProvider;

    @Override
    public void init() {
        CurrencyName c1 = new CurrencyName("doge.csv", "Dodge");
        CurrencyName c2 = new CurrencyName("btc.csv", "Bitcoin");
        currencyNameDao.save(c1);
        currencyNameDao.save(c2);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Template template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME);

        Map<String, Object> model = new HashMap<>();

        List<CurrencyName> currencyList = currencyNameDao.findAll();

        model.put("currencyNameList", currencyList);

        LOG.info("Found {} objects", currencyList.size());

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            LOG.error("Error while processing the template: " + e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String fileName = req.getParameter("fileName");
        final String currencyName = req.getParameter("currencyName");
        CurrencyName newCurrency = new CurrencyName(fileName, currencyName);

        CurrencyName byId = currencyNameDao.findById(fileName);

        if (byId == null) {
            LOG.info("Add new file name = {} and new currency name = {}", fileName, currencyName);

            currencyNameDao.save(newCurrency);
            doGet(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/currency-name-problem");
        }

    }
}
