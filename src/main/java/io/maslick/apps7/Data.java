package io.maslick.apps7;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

@lombok.Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Data {
    private Date date;
    private String app;
    private String platform;
    private Integer requests;
    private Integer impressions;
    private Double revenue;
    private String currency;

    @Override
    public String toString() {
        return "Data{" +
                "date=" + new SimpleDateFormat("dd/MM/yyyy").format(date) +
                ", app='" + app + '\'' +
                ", platform='" + platform + '\'' +
                ", requests=" + requests +
                ", impressions=" + impressions +
                ", revenue=" + revenue +
                ", currency='" + currency + '\'' +
                '}';
    }
}
