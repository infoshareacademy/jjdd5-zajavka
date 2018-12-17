package com.infoshareacademy.zajavka.web;


import com.infoshareacademy.zajavka.dao.DailyDataDao;
import com.infoshareacademy.zajavka.data.DailyData;
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
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/local-extremes")
public class LocalExtremesServlet extends HttpServlet {

    @Inject
    DailyDataDao dailyDataDao;

    @Inject
    private TemplateProvider templateProvider;

    private static final Logger LOG = LoggerFactory.getLogger(SelectDayServlet.class);
    private static final String TEMPLATE_NAME = "localExtremes";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, Object> model = new HashMap<>();
        PrintWriter out = resp.getWriter();

        HttpSession session = req.getSession();
        String currency = (String) session.getAttribute("currency");

        LocalDate startDate = LocalDate.parse(req.getParameter("startDate"));
        LocalDate endDate = LocalDate.parse(req.getParameter("endDate"));


        Template template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME);



        DailyData localMax = dailyDataDao.getLocalMax(currency,startDate,endDate);
        DailyData localMin = dailyDataDao.getLocalMin(currency,startDate,endDate);


       /* out.println("dupa" + localMax.getPriceUSD().toString());
        out.println("dupa" + localMin.getPriceUSD().toString());*/

        model.put("localMax", localMax);
        model.put("localMin", localMin);
        model.put("startDate",startDate);
        model.put("endDate",endDate);


        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            LOG.error("Error while processing the template: " + e);
        }


    }
}