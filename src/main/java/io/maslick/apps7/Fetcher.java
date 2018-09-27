package io.maslick.apps7;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.maslick.apps7.ifaces.IFetcher;
import io.maslick.apps7.ifaces.AbstractUrlBuilder;

public class Fetcher implements IFetcher {

    private AbstractUrlBuilder urlBuilder;

    public Fetcher(AbstractUrlBuilder urlBuilder) {
        this.urlBuilder = urlBuilder;
    }

    @Override
    public String invoke(String url) {
        System.out.println("Fetching from url: " + urlBuilder.build(url));

        try {
            return Unirest
                    .get(urlBuilder.build(url))
                    .asString()
                    .getBody();
        } catch (UnirestException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
