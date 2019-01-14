package com.infoshareacademy.zajavka.api;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PriceClientTest {
    private PriceClient client;
    private static final String NAME_BTC = "BTC";
    private static final String NAME_LTC = "LTC";
    private static final String NAME_ETH = "ETH";

    @Before
    public void setUp() {
        client = new PriceClientImpl();
    }

    @Test
    public void shouldGetBitcoin() {
        PriceResponse priceResponse = client.getPriceForBtc(NAME_BTC);
        assertNotNull(priceResponse.getPrice());
    }
    @Test
    public void shouldGetLitecoin() {
        PriceResponse priceResponse = client.getPriceForBtc(NAME_LTC);
        assertNotNull(priceResponse.getPrice());
    }
    @Test
    public void shouldGetEthcoin() {
        PriceResponse priceResponse = client.getPriceForBtc(NAME_ETH);
        assertNotNull(priceResponse.getPrice());
    }

}