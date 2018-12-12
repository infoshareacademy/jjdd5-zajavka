package com.infoshareacademy.zajavka.web;
/*

import com.infoshareacademy.zajavka.dao.DailyPriceDao;
import com.infoshareacademy.zajavka.dao.CurrencyDao;
*/
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/test")
public class TestServlet extends HttpServlet {

    private static final String TEMPLATE_NAME = "test";

    @Inject
    private TemplateProvider templateProvider;

/*    @Inject
    private DailyPriceDao dailyPriceDao;

    @Inject
    private CurrencyDao currencyDao;*/


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
    }}
/*
        final String action = req.getParameter("action");
        //          LOG.info("Requested action: {}", action);
        if (action == null || action.isEmpty()) {
            resp.getWriter().write("Empty action parameter.");
            return;
        }

        if (action.equals("findAll")) {
            findAll(req, resp);
        } else if (action.equals("add")) {
            addStudent(req, resp);
        } else if (action.equals("delete")) {
            deleteCurrency(req, resp);
        } else if (action.equals("update")) {
            updateStudent(req, resp);
        } else if (action.equals("findByDate")) {
            findByDate(req, resp);
        } else {
            resp.getWriter().write("Unknown action.");
        }
    }*/

/*

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        //dailyprice
        DailyPrice p1 = new DailyPrice(LocalDate.parse("2018-01-02"), BigDecimal.valueOf(30));
        dailyPriceDao.save(p1);

        List<DailyPrice> priceList = new ArrayList<>();
        priceList.add(p1);

        //currency
        Currency bitCoin = new Currency("Bitcoin", priceList);
        currencyDao.save(bitCoin);
    }
}
*/
