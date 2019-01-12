package com.infoshareacademy.zajavka.web;

import com.infoshareacademy.zajavka.dao.CurrencyDao;
import com.infoshareacademy.zajavka.freemarker.TemplateProvider;
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
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;


@WebServlet("/choose")
public class ChoceCurrencyServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(ChoceCurrencyServlet.class);
    private static final String TEMPLATE_NAME = "chooseCurrency";

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private CurrencyDao currencyDao;

    @Inject
    private LoginService loginService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {


        HttpSession session = req.getSession();


        showSide(session,templateProvider, resp, req);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String currency = req.getParameter("currency");
        if (currencyDao.getNames().stream().anyMatch(i -> i.equals(currency))) {
            session.setAttribute("currency", currency);
        }

        showSide(session,templateProvider, resp, req);

    }
    private void showSide(HttpSession session, TemplateProvider templateProvider, HttpServletResponse resp, HttpServletRequest req) throws IOException {
        String chosenCurrency;
        String currency = (String) session.getAttribute("currency");
        Map<String, Object> model = new HashMap<>();
        if (currency == null || currency.isEmpty()) {
            chosenCurrency = "not selected";
        } else {
            chosenCurrency = currency;
            model.put("isCurrencySelected",true);
        }


        loginService.addUserNameToSesionIfLogin(req, model);

        model.put("Names", currencyDao.getNames());
        model.put("chosenCurrency", chosenCurrency);

        Template template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME);

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            LOG.error("Error while processing the template: " + e);
        }
    }

}
