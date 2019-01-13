package com.infoshareacademy.zajavka.web;

import com.infoshareacademy.zajavka.dao.CurrencyNameDao;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;

@WebServlet(urlPatterns = "/currency-name-delete")
@Transactional
public class CurrencyNameDelete extends HttpServlet {

    @Inject
    private CurrencyNameDao currencyNameDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deleteCurrencyName = req.getParameter("name");

        currencyNameDao.delete(deleteCurrencyName);

        resp.sendRedirect(req.getContextPath() + "/currency-name");

    }
}
