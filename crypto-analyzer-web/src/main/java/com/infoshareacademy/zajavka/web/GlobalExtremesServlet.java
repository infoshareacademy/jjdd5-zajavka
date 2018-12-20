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
import java.util.HashMap;
import java.util.Map;

@WebServlet("/global-extremes")
public class GlobalExtremesServlet extends HttpServlet {

    @Inject
    DailyDataDao dailyDataDao;

    @Inject
    private TemplateProvider templateProvider;

    private static final Logger LOG = LoggerFactory.getLogger(SelectDayServlet.class);
    private static final String TEMPLATE_NAME = "globalExtremes";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, Object> model = new HashMap<>();

        HttpSession session = req.getSession();
        String currency = (String) session.getAttribute("currency");

        Template template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME);


        DailyData globalMin = dailyDataDao.getGlobalMin(currency);
        DailyData globalMax = dailyDataDao.getGlobalMax(currency);


        model.put("globalMin", globalMin);
        model.put("globalMax",globalMax);

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            LOG.error("Error while processing the template: " + e);
        }


    }
}