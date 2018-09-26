package io.maslick.apps7.providers.adUmbrella;

import io.maslick.apps7.pojo.Report;
import io.maslick.apps7.ifaces.IParser;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component("adUmbrella1")
public class AdUmbrellaParser implements IParser {

    private final String COMMA = ",";

    @Override
    public List<Report> invoke(String input) {
        System.out.println("Parsing AdUmbrella...");

        List<Report> list = new ArrayList<>();

        try {
            InputStream inputFS = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8.name()));
            BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));

            list = br.lines().skip(1).map(line -> {
                String[] split = line.split(COMMA);
                Date date;
                try {
                    date = new SimpleDateFormat("dd/MM/yyyy").parse(split[0]);
                } catch (ParseException e) {
                    e.printStackTrace();
                    return null;
                }

                return Report.builder()
                        .date(date)
                        .app(split[1])
                        .platform(split[2])
                        .requests(Integer.valueOf(split[3]))
                        .impressions(Integer.valueOf(split[4]))
                        .revenue(Double.valueOf(split[5]))
                        .currency("usd")
                        .build();
            }).filter(Objects::nonNull).collect(Collectors.toList());

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return list ;
    }
}
