package com.infoshareacademy.zajavka.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CURRENCIES")
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Long id;

    @Column(name = "NAME")
    String name;

    @Column(name = "DAILY_PRICE_LIST")
    List<DailyPrice> dailyPriceList;

    public Currency() {
    }

    public Currency(String name, List<DailyPrice> dailyPriceList) {
        this.name = name;
        this.dailyPriceList = dailyPriceList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DailyPrice> getDailyPriceList() {
        return dailyPriceList;
    }

    public void setDailyPriceList(List<DailyPrice> dailyPriceList) {
        this.dailyPriceList = dailyPriceList;
    }
}
