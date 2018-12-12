package com.infoshareacademy.zajavka.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "CURRENCIES")
public class Currency {

    @Id
    @Column(name = "NAME", length = 32)
    String name;

    @OneToMany(mappedBy = "currency", fetch = FetchType.EAGER)
    private List<DailyPrice> dailyPrices;
    public Currency() {
    }

    public Currency(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DailyPrice> getDailyPrices() {
        return dailyPrices;
    }

    public void setDailyPrices(List<DailyPrice> dailyPrices) {
        this.dailyPrices = dailyPrices;
    }
}
