package com.infoshareacademy.zajavka.data;

import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.List;


@Table(name = "CURRENCY", uniqueConstraints = @UniqueConstraint(columnNames = "currency_id"))
public class Currency {
    private String name;
    private List<DailyData> dailyDataList;

    public Currency(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DailyData> getDailyDataList() {
        return dailyDataList;
    }

    public void setDailyDataList(List<DailyData> dailyDataList) {
        this.dailyDataList = dailyDataList;
    }
}

