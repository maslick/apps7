package io.maslick.apps7.service;

import io.maslick.apps7.ifaces.IFetcher;
import io.maslick.apps7.ifaces.IParser;
import io.maslick.apps7.ifaces.IPersister;
import io.maslick.apps7.ifaces.IValidator;
import io.maslick.apps7.pojo.Report;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


public class AdNetwork {
    private String network;
    private IFetcher fetcher;
    private IParser parser;
    private IPersister persister;
    private IValidator validator;

    @Getter
    @Setter
    private String date;

    public AdNetwork(String network, IFetcher fetcher, IValidator validator, IParser parser, IPersister persister) {
        this.network = network;
        this.fetcher = fetcher;
        this.parser = parser;
        this.persister = persister;
        this.validator = validator;
    }

    public void run() {
        if(date != null) {
            if (validator.isOk(network, date, "")) {                    // validate
                String rawCsv = fetcher.invoke(date);                   // fetch csv
                List<Report> parsed = parser.invoke(rawCsv);            // parse it
                persister.invoke(network, parsed);                      // save to db
            }
        }
    }
}