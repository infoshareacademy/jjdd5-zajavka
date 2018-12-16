package com.infoshareacademy.zajavka.data;

import java.util.List;

public class Chart {
    List<String> datesStr;
    String pricesStr;

    public Chart() {
    }

    public List<String> getDatesStr() {
        return datesStr;
    }

    public void setDatesStr(List<String> datesStr) {
        this.datesStr = datesStr;
    }

    public String getPricesStr() {
        return pricesStr;
    }

    public void setPricesStr(String pricesStr) {
        this.pricesStr = pricesStr;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Chart{");
        sb.append("datesStr='").append(datesStr).append('\'');
        sb.append(", pricesStr='").append(pricesStr).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
