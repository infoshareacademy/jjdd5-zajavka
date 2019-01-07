package com.infoshareacademy.zajavka.data;

import com.infoshareacademy.zajavka.dao.ConfigurationDao;
import com.infoshareacademy.zajavka.service.ConfigurationService;

import javax.inject.Inject;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "DAILY_DATES")
public class DailyData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DATE")
    @NotNull
    private LocalDate date;

    @Column(name = "PRICE_USD", precision = 13, scale = 6)
    private BigDecimal priceUSD;

    @ManyToOne
    @JoinColumn(name = "CURRENCY_NAME")
    private Currency currency;

    public DailyData() {
    }

    public DailyData(@NotNull LocalDate date, BigDecimal priceUSD, Currency currency) {
        this.date = date;
        this.priceUSD = priceUSD;
        this.currency = currency;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getStrPriceUSD() {
        return priceUSD.toString();
    }

    public void setPriceUSD(BigDecimal priceUSD) {
        this.priceUSD = priceUSD;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "DailyData{" +
                "id=" + id +
                ", date=" + date +
                ", priceUSD=" + priceUSD +
                ", currency=" + currency.getName() +
                '}';
    }
}
