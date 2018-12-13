package com.infoshareacademy.zajavka.web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.transaction.Transactional;

@WebServlet(urlPatterns = "/currency-name")
@Transactional
public class CurrencyNameServlet extends HttpServlet {
}
