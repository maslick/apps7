package io.maslick.apps7.providers.superNetwork;

import io.maslick.apps7.ifaces.AbstractParser;
import io.maslick.apps7.pojo.Report;

import java.text.ParseException;

public class SuperNetworkParser extends AbstractParser {

    private final String EURO = "€";

    public SuperNetworkParser() {
        this.lambda = split -> {
            try {
                return Report.builder()
                        .date(parseDate(split[0]))
                        .app(split[1])
                        .platform(split[2])
                        .requests(Integer.valueOf(split[3]))
                        .impressions(Integer.valueOf(split[4]))
                        .revenue(Double.valueOf(split[5].split(EURO)[1]))
                        .currency("eur")
                        .build();
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        };
    }
}
