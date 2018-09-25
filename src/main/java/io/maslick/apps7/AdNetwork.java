package io.maslick.apps7;

import io.maslick.apps7.ifaces.IFetcher;
import io.maslick.apps7.ifaces.IParser;
import io.maslick.apps7.ifaces.IPersister;
import lombok.Getter;
import lombok.Setter;


public class AdNetwork {
    private IFetcher fetcher;
    private IParser parser;
    private IPersister persister;

    @Getter
    @Setter
    private String date;

    public AdNetwork(IFetcher fetcher, IParser parser, IPersister persister) {
        this.fetcher = fetcher;
        this.parser = parser;
        this.persister = persister;
    }

    public void run() {
        if(date != null)
            persister.invoke(parser.invoke(fetcher.invoke(date)));
    }
}
