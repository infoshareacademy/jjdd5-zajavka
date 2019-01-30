package com.infoshareacademy.zajavka.web.twoCurrency;

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

@WebServlet("/exchange-history-two")
public class ExchangeRateHistoryForTwoServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(ExchangeRateHistoryForTwoServlet.class);
    private static final String TEMPLATE_NAME = "exchangeHistoryTwo";
    //private static final String TEMPLATE_NAME = "test";

    @Inject
    private DailyDataDao dailyDataDao;

    @Inject
    private ConfigurationService configurationService;

    @Inject
    private LoginService loginService;

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        HttpSession session = req.getSession();
        String chosenCurrencyOne;
        String chosenCurrencyTwo;
        String currencyOne = (String) session.getAttribute("currencyOne");
        String currencyTwo = (String) session.getAttribute("currencyTwo");
        Map<String, Object> model = new HashMap<>();

        loginService.addUserNameToSesionIfLogin(req, model);

        String currencyFullNameOne = (String) session.getAttribute("currencyFullNameOne");
        String currencyFullNameTwo = (String) session.getAttribute("currencyFullNameTwo");

        if ((currencyOne == null || currencyOne.isEmpty()) || (currencyTwo == null || currencyTwo.isEmpty())) {
            chosenCurrencyOne = "not selected";
            chosenCurrencyTwo = "not selected";
        } else {
            DateTimeFormatter formatter = configurationService.dateFormatter();
            Integer afterSign = configurationService.numberAfterSign();

            //first
            List<PriceDTO> pricesOne = dailyDataDao.getAllDailyDatasForCurrency(currencyOne).stream()
                    .map(o -> {
                        BigDecimal formattedPrice = o.getPriceUSD().setScale(afterSign, BigDecimal.ROUND_HALF_DOWN);
                        String date = o.getDate().format(formatter);
                        return new PriceDTO(formattedPrice.toString(), date);
                    })
                    .collect(toList());

            model.put("pricesOne", pricesOne);

            model.put("grafPricesOne", pricesOne.stream().sorted((p1, p2) -> {
                LocalDate d1 = LocalDate.parse(p1.getDate(), formatter);
                LocalDate d2 = LocalDate.parse(p2.getDate(), formatter);
                return d1.compareTo(d2);
            }).collect(toList()));

            //second
            List<PriceDTO> pricesTwo = dailyDataDao.getAllDailyDatasForCurrency(currencyTwo).stream()
                    .map(o -> {
                        BigDecimal formattedPrice = o.getPriceUSD().setScale(afterSign, BigDecimal.ROUND_HALF_DOWN);
                        String date = o.getDate().format(formatter);
                        return new PriceDTO(formattedPrice.toString(), date);
                    })
                    .collect(toList());

            model.put("pricesTwo", pricesTwo);

            model.put("grafPricesTwo", pricesTwo.stream().sorted((p1, p2) -> {
                LocalDate d1 = LocalDate.parse(p1.getDate(), formatter);
                LocalDate d2 = LocalDate.parse(p2.getDate(), formatter);
                return d1.compareTo(d2);
            }).collect(toList()));



            chosenCurrencyOne = currencyFullNameOne;
            chosenCurrencyTwo = currencyFullNameTwo;
            LOG.error(dailyDataDao.getDataChartForCurrency(currencyOne).toString());
            LOG.error(dailyDataDao.getDataChartForCurrency(currencyTwo).toString());
        }

        model.put("chosenCurrencyOne", chosenCurrencyOne);
        model.put("chosenCurrencyTwo", chosenCurrencyTwo);

        Template template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME);

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            LOG.error("Error while processing the template: " + e);
        }

    }


}
