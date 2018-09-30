package io.maslick.apps7.providers.adUmbrella;

import io.maslick.apps7.ifaces.AbstractParser;
import io.maslick.apps7.pojo.Report;

import java.text.ParseException;

public class AdUmbrellaParser extends AbstractParser {

    public AdUmbrellaParser() {
        this.lambda = split -> {
            try {
                return Report.builder()
                        .date(parseDate(split[0]))
                        .app(split[1])
                        .platform(split[2])
                        .requests(Integer.valueOf(split[3]))
                        .impressions(Integer.valueOf(split[4]))
                        .revenue(Double.valueOf(split[5]))
                        .currency("usd")
                        .build();
            } catch (ParseException | NumberFormatException e) {
                e.printStackTrace();
                return null;
            }
        };
    }
}

