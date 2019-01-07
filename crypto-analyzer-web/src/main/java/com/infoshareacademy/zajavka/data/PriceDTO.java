package com.infoshareacademy.zajavka.data;

public class PriceDTO {

    private String price;
    private String date;

    public PriceDTO(String price, String date) {
        this.price = price;
        this.date = date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
