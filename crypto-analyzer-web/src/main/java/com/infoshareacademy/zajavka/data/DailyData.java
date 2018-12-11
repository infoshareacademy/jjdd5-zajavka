package com.infoshareacademy.zajavka.data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "DAILY_DATES")
public class DailyData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "DATE")
    @NotNull
    private LocalDate date;

    @Column(name = "priceUSD")
    private BigDecimal priceUSD;

    @ManyToOne
    @JoinColumn(name = "currency")
    private Currency currency;

    public DailyData(LocalDate date, BigDecimal priceUSD) {
        this.date = date;
        this.priceUSD = priceUSD;
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

    public void setPriceUSD(BigDecimal priceUSD) {
        this.priceUSD = priceUSD;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
