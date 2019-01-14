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
        assertThat(priceResponse.getPrice(), is(3550.29));
    }
    @Test
    public void shouldGetLitecoin() {
        PriceResponse priceResponse = client.getPriceForLtc(NAME_LTC);
        assertThat(priceResponse.getPrice(), is(30.27));
    }
    @Test
    public void shouldGetEthcoin() {
        PriceResponse priceResponse = client.getPriceForEth(NAME_ETH);
        assertThat(priceResponse.getPrice(), is(117.58));
    }

}