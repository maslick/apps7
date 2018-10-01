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
    private final String network;
    private final IFetcher fetcher;
    private final IParser parser;
    private final IPersister persister;
    private final IValidator validator;

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
                String rawCsv = fetcher.download(date);                 // fetch csv
                List<Report> parsed = parser.run(rawCsv);               // parse it
                persister.save(network, parsed);                        // save to db
            }
        }
    }
}