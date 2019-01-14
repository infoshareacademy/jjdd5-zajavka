package com.infoshareacademy.zajavka.api;

import org.codehaus.jackson.annotate.JsonProperty;

import javax.json.bind.annotation.JsonbProperty;

public class PriceResponse {

    @JsonProperty("USD")
    @JsonbProperty("USD")
    private Double price;

    public PriceResponse() {
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PriceResponse{" +
                "price=" + price +
                '}';
    }
}