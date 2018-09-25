package io.maslick.apps7;

import io.maslick.apps7.providers.adUmbrella.AdUmbrellaParser;
import io.maslick.apps7.providers.adUmbrella.AdUmbrellaUrlBuilder;
import io.maslick.apps7.providers.superNetwork.SuperNetworkParser;
import io.maslick.apps7.providers.superNetwork.SuperNetworkUrlBuilder;


public class App {
    public static void main(String[] args) {

        AdNetwork superNetwork = new AdNetwork(new Fetcher(new SuperNetworkUrlBuilder()), new SuperNetworkParser(), new Persister());
        AdNetwork adUmbrella = new AdNetwork(new Fetcher(new AdUmbrellaUrlBuilder()), new AdUmbrellaParser(), new Persister());

        String date = "15.09.2017";
        superNetwork.setDate(date);
        adUmbrella.setDate(date);

        superNetwork.run();
        adUmbrella.run();
    }
}


