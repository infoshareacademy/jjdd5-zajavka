package com.infoshareacademy.zajavka.data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CURRENCIES")
public class Currency {

    @Id
    @Column(name = "NAME", length = 32)
    private String name;

    @OneToMany(mappedBy = "currency", fetch = FetchType.EAGER)
    private List<DailyData> dailyDataList;

    public Currency() {
    }

    public Currency(String name, List<DailyData> dailyDataList) {
        this.name = name;
        this.dailyDataList = dailyDataList;
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

