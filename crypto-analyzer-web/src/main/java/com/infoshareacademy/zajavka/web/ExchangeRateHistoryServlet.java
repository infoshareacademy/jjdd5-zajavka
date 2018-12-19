package com.infoshareacademy.zajavka.web;


import com.infoshareacademy.zajavka.dao.DailyDataDao;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/rateHistory")
public class ExchangeRateHistoryServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(CurrentValueServlet.class);
    private static final String TEMPLATE_NAME = "rateHistory";

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private DailyDataDao dailyDataDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String chosenCurrency;
        Map<String, Object> model = new HashMap<>();
        String currency = (String) session.getAttribute("currency");
        if (currency == null || currency.isEmpty()){
            chosenCurrency="No chosen currency";
        } else {
            model.put("DailyDatas", dailyDataDao.getAllDailyDatasForCurrency(currency));
            chosenCurrency="Actual currency: " + currency;
            LOG.error(dailyDataDao.getDataChartForCurrency(currency).toString());
            model.put("ChartData", dailyDataDao.getDataChartForCurrency(currency));
        }

        model.put("chosenCurrency", chosenCurrency);

        Template template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME);

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            LOG.error("Error while processing the template: " + e);
        }

    }

}

