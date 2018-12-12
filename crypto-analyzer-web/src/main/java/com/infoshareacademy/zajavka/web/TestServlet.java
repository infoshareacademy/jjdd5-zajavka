package com.infoshareacademy.zajavka.web;
/*

import com.infoshareacademy.zajavka.dao.DailyPriceDao;
import com.infoshareacademy.zajavka.dao.CurrencyDao;
*/

import com.infoshareacademy.zajavka.dao.CurrencyDao;
import com.infoshareacademy.zajavka.dao.DailyPriceDao;
import com.infoshareacademy.zajavka.domain.Currency;
import com.infoshareacademy.zajavka.domain.DailyPrice;
import
        com.infoshareacademy.zajavka.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@WebServlet(urlPatterns = "/test")
public class TestServlet extends HttpServlet {

    private static final String TEMPLATE_NAME = "test";

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private DailyPriceDao dailyPriceDao;

    @Inject
    private CurrencyDao currencyDao;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, Object> model = new HashMap<>();
        model.put("date", LocalDateTime.now());

        Template template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME);

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        List<DailyPrice> priceList = new ArrayList<>();

        //currency
        Currency c1 = new Currency("Bitcoin");
        currencyDao.save(c1);

        Currency c2 = new Currency("LiteCoin");
        currencyDao.save(c2);

        //dailyprice
        DailyPrice p1 = new DailyPrice(LocalDate.parse("2018-01-02"), BigDecimal.valueOf(30),c1);
        dailyPriceDao.save(p1);
        DailyPrice p2 = new DailyPrice(LocalDate.parse("2007-01-02"), BigDecimal.valueOf(60),c1);
        dailyPriceDao.save(p2);
        DailyPrice p3 = new DailyPrice(LocalDate.parse("2001-01-02"), BigDecimal.valueOf(90),c2);
        dailyPriceDao.save(p3);
        DailyPrice p4 = new DailyPrice(LocalDate.parse("1993-08-04"), BigDecimal.valueOf(78),c2);
        dailyPriceDao.save(p4);


    }
}

