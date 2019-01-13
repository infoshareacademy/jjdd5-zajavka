package com.infoshareacademy.zajavka.web;

import com.infoshareacademy.zajavka.dao.DailyDataDao;
import com.infoshareacademy.zajavka.data.DailyData;
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
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/select-day")
public class SelectDayServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private DailyDataDao dailyDataDao;

    @Inject
    private ConfigurationService configurationService;

    private static final Logger LOG = LoggerFactory.getLogger(SelectDayServlet.class);
    private static final String TEMPLATE_NAME = "selectDay";
    private static final String TEMPLATE_NAME_SELECTED = "selectedDay";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param1 = req.getParameter("date");

        Map<String, Object> model = new HashMap<>();

        Template template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME);

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            LOG.error("Error while processing the template: " + e);
        }

        model.put("date", param1);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Template template2 = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME_SELECTED);
        Map<String, Object> model = new HashMap<>();
        PrintWriter out = resp.getWriter();

        DateTimeFormatter formatter = configurationService.dateFormatter();


        HttpSession session = req.getSession();
        String currency = (String) session.getAttribute("currency");
        String currencyFullName = (String) session.getAttribute("currencyFullName");

        String param1 = req.getParameter("date");

        DailyData dd = dailyDataDao.getPriceForSelectedDay(LocalDate.parse(param1), currency);

        LocalDate dailyDataDate = dd.getDate();

        BigDecimal priceUsd = dd.getPriceUSD();
        String formattedDailyDataPrice = priceUsd.setScale(configurationService.numberAfterSign(), BigDecimal.ROUND_HALF_DOWN).toString();

        model.put("dailyDataDate", formatter.format(dailyDataDate));
        model.put("formattedDailyDataPrice", formattedDailyDataPrice);


        try {
            template2.process(model, resp.getWriter());
        } catch (TemplateException e) {
            LOG.error("Error while processing the template: " + e);
        }


    }
}
