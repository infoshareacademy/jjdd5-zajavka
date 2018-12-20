package com.infoshareacademy.zajavka.web;

import com.infoshareacademy.zajavka.dao.DailyDataDao;
import com.infoshareacademy.zajavka.data.DailyData;
import com.infoshareacademy.zajavka.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.jms.Session;
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

@WebServlet("/selected-day")
public class SelectedDayServlet extends HttpServlet {

    @Inject
    DailyDataDao dailyDataDao;

    @Inject
    private TemplateProvider templateProvider;

    private static final Logger LOG = LoggerFactory.getLogger(SelectDayServlet.class);
    private static final String TEMPLATE_NAME = "selectedDay";
    private static final String WRONG_TEMPLATE_NAME = "somethingWrong";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Template template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME);
        Map<String, Object> model = new HashMap<>();
        PrintWriter out = resp.getWriter();

        try {


            HttpSession session = req.getSession();
            String currency = (String) session.getAttribute("currency");

            String param1 = req.getParameter("date");

            if (currency == null || currency.isEmpty()) {
                out.println("no currency");
            } else {
                DailyData dd = dailyDataDao.getPriceForSelectedDay(LocalDate.parse(param1), currency);

                model.put("price", dd);

            }
            try {
                template.process(model, resp.getWriter());
            } catch (TemplateException e) {
                LOG.error("Error while processing the template: " + e);
            }
        }
        catch (Exception e){
            Template template2 = templateProvider.getTemplate(getServletContext(), WRONG_TEMPLATE_NAME);
            try {
                template.process(model, resp.getWriter());
            } catch (TemplateException f) {
                LOG.error("Error while processing the template: " + f);
            }
        }





    }
}
