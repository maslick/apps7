package io.maslick.apps7.providers.adUmbrella;

import io.maslick.apps7.ifaces.UrlBuilder;


public class AdUmbrellaUrlBuilder extends UrlBuilder {

    public AdUmbrellaUrlBuilder() {
        DATE_FORMAT = "dd_M_yyyy"; // 16_9_2017
        URL_PREFIX = "https://storage.googleapis.com/expertise-test/reporting/adumbrella/adumbrella-";
        URL_POSTFIX = ".csv";
    }
}
