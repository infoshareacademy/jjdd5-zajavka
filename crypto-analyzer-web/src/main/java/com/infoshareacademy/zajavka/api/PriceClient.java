package com.infoshareacademy.zajavka.api;

public interface PriceClient {
    PriceResponse getPriceForBtc(String name);
    PriceResponse getPriceForEth(String name);
    PriceResponse getPriceForLtc(String name);
}
