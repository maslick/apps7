package io.maslick.apps7.providers.adUmbrella;

import io.maslick.apps7.ifaces.AbstractParser;
import io.maslick.apps7.pojo.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AdUmbrellaParser extends AbstractParser {

    public AdUmbrellaParser() {
        this.lambda = split -> {
            try {
                Date date = new SimpleDateFormat("dd/MM/yyyy").parse(split[0]);
                return Data.builder()
                        .date(date)
                        .app(split[1])
                        .platform(split[2])
                        .requests(Integer.valueOf(split[3]))
                        .impressions(Integer.valueOf(split[4]))
                        .revenue(Double.valueOf(split[5]))
                        .currency("usd")
                        .build();
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        };
    }
}

