package com.infoshareacademy.zajavka.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "CURRENCIES")
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Long id;

    @Column(name = "NAME")
    String name;

    @OneToMany(mappedBy = "currency", fetch = FetchType.EAGER)
    private Set<DailyPrice> dailyPrices;

    public Currency() {
    }

    public Currency(String name, Set<DailyPrice> dailyPrices) {
        this.name = name;
        this.dailyPrices = dailyPrices;
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

    public Set<DailyPrice> getDailyPrices() {
        return dailyPrices;
    }

    public void setDailyPrices(Set<DailyPrice> dailyPrices) {
        this.dailyPrices = dailyPrices;
    }
}
