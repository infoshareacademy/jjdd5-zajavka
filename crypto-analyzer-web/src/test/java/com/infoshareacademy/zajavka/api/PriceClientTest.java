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
        String priceResponse = client.getPriceForBtc(NAME_BTC);
        assertNotNull(priceResponse);
    }
    @Test
    public void shouldGetLitecoin() {
        String priceResponse = client.getPriceForBtc(NAME_LTC);
        assertNotNull(priceResponse);
    }
    @Test
    public void shouldGetEthcoin() {
        String priceResponse = client.getPriceForBtc(NAME_ETH);
        assertNotNull(priceResponse);
    }

}