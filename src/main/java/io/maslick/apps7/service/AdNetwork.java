package io.maslick.apps7.service;

import io.maslick.apps7.ifaces.IFetcher;
import io.maslick.apps7.ifaces.IParser;
import io.maslick.apps7.ifaces.IPersister;
import io.maslick.apps7.pojo.Report;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


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
        if(date != null) {
            String rawCsv = fetcher.invoke(date);
            System.out.println(rawCsv);
            List<Report> parsed = parser.invoke(rawCsv);
            System.out.println(parsed.size());
            persister.invoke(parsed);
        }
    }
}
