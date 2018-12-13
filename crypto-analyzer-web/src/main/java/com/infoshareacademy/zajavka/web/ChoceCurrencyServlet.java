package com.infoshareacademy.zajavka.web;

import com.infoshareacademy.zajavka.dao.CurrencyDao;
import com.infoshareacademy.zajavka.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;


@WebServlet("/chose")
public class ChoceCurrencyServlet extends HttpServlet {

    private static final String TEMPLATE_NAME = "choseCurrency";

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private CurrencyDao currencyDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Map<String, Object> model = new HashMap<>();


        model.put("Names", currencyDao.getNames());

        Template template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME);

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String currency = req.getParameter("currency");
        HttpSession session = req.getSession();
        session.setAttribute("currency", currency);

        resp.getWriter().println("Wybrales: " + currency);
    }
}
