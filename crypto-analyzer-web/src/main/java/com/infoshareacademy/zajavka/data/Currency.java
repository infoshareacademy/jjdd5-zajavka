package com.infoshareacademy.zajavka.data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CURRENCIES")
public class Currency {

    @Id
    @Column(name = "NAME")
    private String name;


    @OneToMany(mappedBy = "currency", fetch = FetchType.EAGER)
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

