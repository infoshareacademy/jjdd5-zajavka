package com.infoshareacademy.zajavka.data;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DailyData {
    private LocalDate date;
    private BigDecimal priceUSD;

    public DailyData(LocalDate date, BigDecimal priceUSD) {
        this.date = date;
        this.priceUSD = priceUSD;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getPriceUSD() {
        return priceUSD;
    }

    public void setPriceUSD(BigDecimal priceUSD) {
        this.priceUSD = priceUSD;
    }
}
