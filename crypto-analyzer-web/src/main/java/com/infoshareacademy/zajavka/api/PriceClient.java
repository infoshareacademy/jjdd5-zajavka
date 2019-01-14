package com.infoshareacademy.zajavka.api;

public interface PriceClient {
    PriceResponse getPriceForBtc();
    PriceResponse getPriceForEth();
    PriceResponse getPriceForLtc();
}
