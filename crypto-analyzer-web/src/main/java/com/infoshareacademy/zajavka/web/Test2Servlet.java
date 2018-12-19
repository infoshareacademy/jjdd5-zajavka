package com.infoshareacademy.zajavka.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/check-choice")
public class Test2Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String currency = (String) session.getAttribute("currency");

        if (currency != null) {
            resp.getWriter().println("Zapamietana waluta: " + currency);
        } else {
            resp.getWriter().println("Nie wybrano waluty");
        }
    }
}
