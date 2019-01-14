package com.infoshareacademy.zajavka.api;

import org.codehaus.jackson.annotate.JsonProperty;

public class PriceResponse<T> {

    @JsonProperty("USD")
    private T price;


    public PriceResponse() {
    }

    public T getPrice() {
        return price;
    }

    public void setPrice(T price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PriceResponse{" +
                "price=" + price +
                '}';
    }
}