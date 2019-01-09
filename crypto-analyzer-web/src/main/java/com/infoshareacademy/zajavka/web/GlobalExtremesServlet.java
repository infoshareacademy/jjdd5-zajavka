package com.infoshareacademy.zajavka.web;


import com.infoshareacademy.zajavka.dao.DailyDataDao;
import com.infoshareacademy.zajavka.freemarker.TemplateProvider;
import com.infoshareacademy.zajavka.service.ConfigurationService;
import com.infoshareacademy.zajavka.service.LoginService;
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

@WebServlet("/global-extremes")
public class GlobalExtremesServlet extends HttpServlet {

    @Inject
    DailyDataDao dailyDataDao;

    @Inject
    private ConfigurationService configurationService;

    @Inject
    private TemplateProvider templateProvider;

    private static final Logger LOG = LoggerFactory.getLogger(SelectDayServlet.class);
    private static final String TEMPLATE_NAME = "globalExtremes";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, Object> model = new HashMap<>();

        model = LoginService.addUserNameToSesionIfLogin(req, model);

        HttpSession session = req.getSession();
        String currency = (String) session.getAttribute("currency");

        Template template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME);

        DateTimeFormatter formatter = configurationService.dateFormatter();
        Integer afterSign = configurationService.numberAfterSign();


        String globalMinPrice = dailyDataDao.getGlobalMin(currency).getPriceUSD().setScale(afterSign, BigDecimal.ROUND_HALF_DOWN).toString();
        LocalDate globalMinDate = dailyDataDao.getGlobalMin(currency).getDate();
        String formattedGlobalMinDate = formatter.format(globalMinDate);

        String globalMaxPrice = dailyDataDao.getGlobalMax(currency).getPriceUSD().setScale(afterSign, BigDecimal.ROUND_HALF_DOWN).toString();
        LocalDate globalMaxDate = dailyDataDao.getGlobalMax(currency).getDate();
        String formattedGlobalMaxDate = formatter.format(globalMaxDate);

        model.put("globalMinPrice", globalMinPrice);
        model.put("globalMinDate", formattedGlobalMinDate);


        model.put("globalMaxPrice", globalMaxPrice);
        model.put("globalMaxDate", formattedGlobalMaxDate);

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            LOG.error("Error while processing the template: " + e);
        }


    }
}