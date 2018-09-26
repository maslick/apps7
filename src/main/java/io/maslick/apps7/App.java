package io.maslick.apps7;

import io.maslick.apps7.ifaces.IParser;
import io.maslick.apps7.ifaces.IPersister;
import io.maslick.apps7.ifaces.UrlBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}


@Component
class Cli implements CommandLineRunner {

    @Autowired
    @Qualifier("superNetwork2")
    UrlBuilder superNetworkUrl;

    @Autowired
    @Qualifier("superNetwork1")
    IParser superNetworkParser;

    @Autowired
    IPersister persister;



    @Override
    public void run(String... args) throws Exception {
        AdNetwork superNetwork = new AdNetwork(
                new Fetcher(superNetworkUrl),
                superNetworkParser,
                persister
        );
        superNetwork.setDate("15.09.2017");
        superNetwork.run();
    }
}