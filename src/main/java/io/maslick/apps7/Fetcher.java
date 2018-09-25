package io.maslick.apps7;

import io.maslick.apps7.ifaces.IFetcher;
import io.maslick.apps7.ifaces.UrlBuilder;

public class Fetcher implements IFetcher {

    private UrlBuilder urlBuilder;

    public Fetcher(UrlBuilder urlBuilder) {
        this.urlBuilder = urlBuilder;
    }

    @Override
    public String invoke(String url) {
        System.out.println("Fetching from url: " + urlBuilder.build(url));
        return "";
    }
}
