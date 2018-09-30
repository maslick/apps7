package io.maslick.apps7.service;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.maslick.apps7.ifaces.IFetcher;
import io.maslick.apps7.ifaces.AbstractUrlBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Fetcher implements IFetcher {

    private AbstractUrlBuilder urlBuilder;
    private Logger logger = LoggerFactory.getLogger(ValidatorAlreadySaved.class);

    public Fetcher(AbstractUrlBuilder urlBuilder) {
        this.urlBuilder = urlBuilder;
    }

    @Override
    public String invoke(String url) {
        logger.info("Fetching from url: " + urlBuilder.build(url));

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
