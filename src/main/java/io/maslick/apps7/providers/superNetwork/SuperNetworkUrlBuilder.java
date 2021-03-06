package io.maslick.apps7.providers.superNetwork;

import io.maslick.apps7.ifaces.AbstractUrlBuilder;

public class SuperNetworkUrlBuilder extends AbstractUrlBuilder {

    public SuperNetworkUrlBuilder() {
        DATE_FORMAT = "yyyy-MM-dd"; // 2017-09-16
        URL_PREFIX = "https://storage.googleapis.com/expertise-test/supernetwork/report/daily/";
        URL_POSTFIX = ".csv";
    }
}
