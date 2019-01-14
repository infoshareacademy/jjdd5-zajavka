package com.infoshareacademy.zajavka.api;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;


@ApplicationScoped
public class PriceClientImpl implements PriceClient {

    private static final String PRICE_API =
            "https://min-api.cryptocompare.com/data/price?tsyms=USD&fsym=";

    @Override
    public PriceResponse getPriceForBtc() {
        String name = "BTC";
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(PRICE_API + name);
        Response response = target.request().get();
        PriceResponse restResponse = response
                .readEntity(PriceResponse.class);
        response.close();

        return restResponse;
    }

    @Override
    public PriceResponse getPriceForEth() {
        String name = "ETH";
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(PRICE_API + name);
        Response response = target.request().get();
        PriceResponse restResponse = response
                .readEntity(PriceResponse.class);
        response.close();

        return restResponse;
    }

    @Override
    public PriceResponse getPriceForLtc() {
        String name = "LTC";
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(PRICE_API + name);
        Response response = target.request().get();
        PriceResponse restResponse = response
                .readEntity(PriceResponse.class);
        response.close();

        return restResponse;
    }
}
