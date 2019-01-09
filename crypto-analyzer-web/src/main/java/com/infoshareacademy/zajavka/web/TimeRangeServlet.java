package com.infoshareacademy.zajavka.web;


import com.infoshareacademy.zajavka.dao.DailyDataDao;
import com.infoshareacademy.zajavka.data.PriceDTO;
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
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

@WebServlet("/time-range")
public class TimeRangeServlet extends HttpServlet {

    @Inject
    DailyDataDao dailyDataDao;

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private ConfigurationService configurationService;

    private static final Logger LOG = LoggerFactory.getLogger(SelectDayServlet.class);
    private static final String TEMPLATE_NAME = "selectTimeRange";
    private static final String TEMPLATE_NAME_RESULT = "pricesTimeRange";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, Object> model = new HashMap<>();

        model = LoginService.addUserNameToSesionIfLogin(req, model);

        Template template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME);

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            LOG.error("Error while processing the template: " + e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Template template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME_RESULT);

        Map<String, Object> model = new HashMap<>();
        HttpSession session = req.getSession();

        String currency = (String) session.getAttribute("currency");

        DateTimeFormatter formatter = configurationService.dateFormatter();
        Integer afterSign = configurationService.numberAfterSign();

        LocalDate startDate = LocalDate.parse(req.getParameter("startDate"));
        LocalDate endDate = LocalDate.parse(req.getParameter("endDate"));

        List<PriceDTO> prices = dailyDataDao.getPricesInTimeRange(currency,startDate,endDate).stream()
                .map(o -> {
                    BigDecimal formattedPrice =o.getPriceUSD().setScale(afterSign,BigDecimal.ROUND_HALF_DOWN);
                    String date = o.getDate().format(formatter);
                    return new PriceDTO(formattedPrice.toString(), date);
                })
                .collect(toList());

        model.put("prices", prices);

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            LOG.error("Error while processing the template: " + e);
        }
    }
}