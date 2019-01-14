package com.infoshareacademy.zajavka.api;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PriceClientTest {
    private PriceClient client;

    @Before
    public void setUp() {
        client = new PriceClientImpl();
    }

    @Test
    public void shouldGetBitcoin() {
        PriceResponse priceResponse = client.getPriceForBtc();
        assertThat(priceResponse.getPrice(), is(3550.29));
    }
    @Test
    public void shouldGetLitecoin() {
        PriceResponse priceResponse = client.getPriceForLtc();
        assertThat(priceResponse.getPrice(), is(30.27));
    }
    @Test
    public void shouldGetEthcoin() {
        PriceResponse priceResponse = client.getPriceForEth();
        assertThat(priceResponse.getPrice(), is(117.58));
    }

}