package com.infoshareacademy.zajavka.data;

import java.util.Comparator;

public class CurrencyComparator implements Comparator<DailyData> {
    @Override
    public int compare(DailyData d1, DailyData d2) {
        return d2.Date().compareTo(d1.Date());
    }
}
