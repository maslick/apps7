package io.maslick.apps7;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CsvNetLoaderAdUmbrella {

    private static final String COMMA = ",";

    public static List<Data> processInputFile(String input) {
        List<Data> list = new ArrayList<>();

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

                return Data.builder()
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