package com.infoshareacademy.zajavka.web;


import com.infoshareacademy.zajavka.data.PriceDTO;
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
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

@WebServlet("/rateHistory")
public class ExchangeRateHistoryServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(CurrentValueServlet.class);
    private static final String TEMPLATE_NAME = "rateHistory";

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private DailyDataDao dailyDataDao;

    @Inject
    private ConfigurationService configurationService;

    @Inject
    private LoginService loginService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String chosenCurrency;
        Map<String, Object> model = new HashMap<>();

        loginService.addUserNameToSesionIfLogin(req, model);

        String currency = (String) session.getAttribute("currency");
        if (currency == null || currency.isEmpty()) {
            chosenCurrency = "not selected";
        } else {
            DateTimeFormatter formatter = configurationService.dateFormatter();
            Integer afterSign = configurationService.numberAfterSign();

            List<PriceDTO> prices = dailyDataDao.getAllDailyDatasForCurrency(currency).stream()
                    .map(o -> {
                        BigDecimal formattedPrice = o.getPriceUSD().setScale(afterSign, BigDecimal.ROUND_HALF_DOWN);
                        String date = o.getDate().format(formatter);
                        return new PriceDTO(formattedPrice.toString(), date);
                    })
                    .collect(toList());

            model.put("prices", prices);

            model.put("grafPrices", prices.stream().sorted((p1, p2) -> {
                LocalDate d1 = LocalDate.parse(p1.getDate(), formatter);
                LocalDate d2 = LocalDate.parse(p2.getDate(), formatter);
                return d1.compareTo(d2);
            }).collect(toList()));


            chosenCurrency = currency;
            LOG.error(dailyDataDao.getDataChartForCurrency(currency).toString());
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

