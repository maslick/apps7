package io.maslick.apps7.providers.superNetwork;

import io.maslick.apps7.ifaces.UrlBuilder;
import org.springframework.stereotype.Component;

@Component("superNetwork2")
public class SuperNetworkUrlBuilder extends UrlBuilder {

    public SuperNetworkUrlBuilder() {
        DATE_FORMAT = "yyyy-MM-dd"; // 2017-09-16
        URL_PREFIX = "https://storage.googleapis.com/expertise-test/supernetwork/report/daily/";
        URL_POSTFIX = ".csv";
    }
}
