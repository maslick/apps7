package io.maslick.apps7;

import io.maslick.apps7.providers.adUmbrella.AdUmbrellaParser;
import io.maslick.apps7.providers.adUmbrella.AdUmbrellaUrlBuilder;
import io.maslick.apps7.providers.superNetwork.SuperNetworkParser;
import io.maslick.apps7.providers.superNetwork.SuperNetworkUrlBuilder;
import io.maslick.apps7.service.AdNetwork;
import io.maslick.apps7.service.Fetcher;
import io.maslick.apps7.service.Persister;
import org.junit.Test;

public class IntegrationTest {

    @Test
    public void testSuperNetwork() {
        AdNetwork superNetwork = new AdNetwork(new Fetcher(new SuperNetworkUrlBuilder()), new SuperNetworkParser(), new Persister());
        superNetwork.setDate("15.09.2017");
        superNetwork.run();
    }

    @Test
    public void testAdUmbrella() {
        AdNetwork adUmbrella = new AdNetwork(new Fetcher(new AdUmbrellaUrlBuilder()), new AdUmbrellaParser(), new Persister());
        adUmbrella.setDate("15.09.2017");
        adUmbrella.run();
    }

}
