package com.infoshareacademy.zajavka.web;

import com.infoshareacademy.zajavka.dao.DailyDataDao;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/current")
public class CurrentValueServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(CurrentValueServlet.class);
    private static final String TEMPLATE_NAME = "currentValue";

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private DailyDataDao dailyDataDao;

    @Inject
    private ConfigurationService configurationService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DateTimeFormatter formatter = configurationService.dateFormatter();

        HttpSession session = req.getSession();
        String chosenCurrency;
        Map<String, Object> model = new HashMap<>();
        String currency = (String) session.getAttribute("currency");
        if (currency == null || currency.isEmpty()) {
            chosenCurrency = "No chosen currency";
        } else {
            LocalDate dailyDataDate = dailyDataDao.getMostActualDataForCurrency(currency).getDate();

            BigDecimal priceUsd = dailyDataDao.getMostActualDataForCurrency(currency).getPriceUSD();
            String formattedDailyDataPrice = priceUsd.setScale(configurationService.numberAfterSign(),BigDecimal.ROUND_HALF_DOWN).toString();

            model.put("DailyDataDate", formatter.format(dailyDataDate));
            model.put("DailyDataPrice", formattedDailyDataPrice);
            chosenCurrency = "Actual currency: " + currency;
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
