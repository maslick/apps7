package io.maslick.apps7;

import io.maslick.apps7.ifaces.IPersister;
import io.maslick.apps7.ifaces.IValidator;
import io.maslick.apps7.providers.adUmbrella.AdUmbrellaParser;
import io.maslick.apps7.providers.adUmbrella.AdUmbrellaUrlBuilder;
import io.maslick.apps7.providers.superNetwork.SuperNetworkParser;
import io.maslick.apps7.providers.superNetwork.SuperNetworkUrlBuilder;
import io.maslick.apps7.service.AdNetwork;
import io.maslick.apps7.service.Fetcher;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class Config {
    private final IPersister persister;
    private final IValidator validator;

    @Bean(name = "superNetwork")
    AdNetwork getSuperNetwork() {
        return new AdNetwork(
                "superNetwork",
                new Fetcher(new SuperNetworkUrlBuilder()),
                validator,
                new SuperNetworkParser(),
                persister
        );
    }

    @Bean(name = "adUmbrella")
    AdNetwork getAdUmbrella() {
        return new AdNetwork(
                "adUmbrella",
                new Fetcher(new AdUmbrellaUrlBuilder()),
                validator,
                new AdUmbrellaParser(),
                persister
        );
    }
}
