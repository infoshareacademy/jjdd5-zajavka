package com.infoshareacademy.zajavka.web.twoCurrency;

import com.infoshareacademy.zajavka.dao.CurrencyDao;
import com.infoshareacademy.zajavka.freemarker.TemplateProvider;
import com.infoshareacademy.zajavka.service.CurrencyNameService;
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
import java.util.HashMap;
import java.util.Map;

@WebServlet("/choice-two")
public class ChoiceTwoCurrencyServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(ChoiceTwoCurrencyServlet.class);
    private static final String TEMPLATE_NAME = "choiceTwoCurrency";

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private LoginService loginService;

    @Inject
    private CurrencyNameService currencyNameService;

    @Inject
    private CurrencyDao currencyDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        HttpSession session = req.getSession();

        showSide(session, templateProvider, resp, req);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        HttpSession session = req.getSession();
        String currencyOne = req.getParameter("currencyFullNameOne");
        String currencyTwo = req.getParameter("currencyFullNameTwo");

        if ((currencyDao.getNames().stream().anyMatch(i -> i.equals(currencyOne))) & (currencyDao.getNames().stream().anyMatch(i -> i.equals(currencyTwo)))) {
            session.setAttribute("currencyFullNameOne", currencyNameService.CurrencyList().get(currencyOne));
            session.setAttribute("currencyFullNameTwo", currencyNameService.CurrencyList().get(currencyTwo));
            session.setAttribute("currencyOne", currencyOne);
            session.setAttribute("currencyTwo", currencyTwo);
        }
        showSide(session, templateProvider, resp, req);
    }

    private void showSide(HttpSession session, TemplateProvider templateProvider, HttpServletResponse resp, HttpServletRequest req) throws IOException {
        String chosenCurrencyOne;
        String chosenCurrencyTwo;
        String currencyOne = (String) session.getAttribute("currencyOne");
        String currencyTwo = (String) session.getAttribute("currencyTwo");
        Map<String, Object> model = new HashMap<>();
        String currencyFullNameOne = (String) session.getAttribute("currencyFullNameOne");
        String currencyFullNameTwo = (String) session.getAttribute("currencyFullNameTwo");

        if ((currencyOne == null || currencyOne.isEmpty()) || (currencyTwo == null || currencyTwo.isEmpty())) {
            chosenCurrencyOne = "not selected";
            chosenCurrencyTwo = "not selected";
        } else {
            chosenCurrencyOne = currencyFullNameOne;
            chosenCurrencyTwo = currencyFullNameTwo;
            model.put("isCurrencySelected", true);
        }


        loginService.addUserNameToSesionIfLogin(req, model);

        model.put("newListCurrencyStandard", currencyNameService.CurrencyListStandard());
        model.put("newListCurrencyPromote", currencyNameService.CurrencyListPromote());

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
