package com.infoshareacademy.zajavka.data;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DailyQuote {
    private LocalDate date;
    private BigDecimal price;

    public DailyQuote(LocalDate date, BigDecimal price) {
        this.date = date;
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
